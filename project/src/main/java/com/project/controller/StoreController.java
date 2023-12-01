package com.project.controller;

import com.project.aspect.TokenRequired;
import com.project.domain.MemberVO;
import com.project.domain.OfferVO;
import com.project.domain.StoreProductVO;
import com.project.service.FileUpload;
import com.project.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class StoreController {
    private final FileUpload fileUpload;
    private final StoreService storeService;

    @Value("${file.dir}")
    private String PATH;

    // 글작성 폼

    @GetMapping("/writeProduct")
    public String addProduct(@ModelAttribute StoreProductVO storeProductVO, Model model, @RequestHeader("Authorization") String token) {
        model.addAttribute("storedToken", token);
        model.addAttribute( "product", storeProductVO);
        return "store/writeProduct";
    }

    @PostMapping("/writeProduct")
    public String addProductForm(@ModelAttribute StoreProductVO storeProductVO, Model model, HttpSession session, RedirectAttributes rttr) throws IOException {
        MemberVO member = (MemberVO) session.getAttribute("loginMember");
        log.info("write storeProductVO {}", storeProductVO);
        String productCategory = storeProductVO.getProduct_category();

        rttr.addAttribute("productCategory", productCategory);
        // 저장
        storeService.addProductForm(storeProductVO);
        return "redirect:/store/{productCategory}";
    }

    @GetMapping("/productInfo")
    public String offerInfo(Long product_no , Model model, HttpSession session){
        log.info("product_no : {}", product_no);
        StoreProductVO storeProductVO = storeService.getProduct(product_no);
        model.addAttribute( "product", storeProductVO);
        session.setAttribute("product_no", product_no);
        return "store/productInfo";
    }

    @ResponseBody
    @GetMapping("/upload/{product_img}")
    public Resource getImage(@PathVariable("product_img") String fileName) throws MalformedURLException {
        return new UrlResource("file:" + PATH + fileName);
    }

    @GetMapping("/updateProduct")
    public String storeUpdate(Long product_no, Model model) {
        log.info("product_no : {}", product_no);
        StoreProductVO storeProductVO = storeService.getProduct(product_no);
        model.addAttribute( "product", storeProductVO);
        return "store/updateProduct";
    }

    @PostMapping("/updateProduct")
    public String storeUpdatePro(Long product_no , @ModelAttribute StoreProductVO storeProductVO) throws IOException {
        log.info("product_no : {}", product_no);
        storeService.updateStore(storeProductVO);
        return "redirect:/productInfo?product_no=" + product_no;
    }

    @PostMapping("/deleteProduct")
    public String deletePro(@RequestParam Long product_no, RedirectAttributes rttr) {
        log.info("delete product_no : {}", product_no);
        String productCategory = storeService.getProduct(product_no).getProduct_category();
        rttr.addAttribute("productCategory", productCategory);
        storeService.deleteProduct(product_no);
        return "redirect:/store/{productCategory}";
    }
}
