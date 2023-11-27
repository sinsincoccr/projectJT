package com.project.repository;


import com.project.domain.OfferVO;
import com.project.dto.Pager;
import com.project.entity.OfferEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface JPAOfferMapper extends JpaRepository<OfferEntity, Long> {

    @Query("SELECT o FROM OfferEntity o WHERE o.offer_category = 'editer' ORDER BY o.offer_no ASC")
    List<OfferEntity> findEditer();

    @Query("SELECT COUNT(o) FROM OfferEntity o WHERE o.offer_category = 'editer'")
    Long findEditerCount(Pager pager);

    @Query("SELECT o FROM OfferEntity o WHERE o.offer_category = 'editer'")
    List<OfferEntity> getEditorListWithPaging(Pager pager);

    @Query("SELECT o FROM OfferEntity o WHERE o.offer_category = 'thumbnailer' ORDER BY o.offer_no ASC")
    List<OfferEntity> findThumbnailer();

    @Query("SELECT COUNT(o) FROM OfferEntity o WHERE o.offer_category = 'thumbnailer'")
    Long findThumbnailerCount(Pager pager);

    @Query("SELECT o FROM OfferEntity o WHERE o.offer_category = 'thumbnailer'")
    List<OfferEntity> getThumbnailerListWithPaging(Pager pager);

    @Query("SELECT o FROM OfferEntity o WHERE o.offer_category = 'sdCharacter' ORDER BY o.offer_no ASC")
    List<OfferEntity> findSdCharacter();

    @Query("SELECT COUNT(o) FROM OfferEntity o WHERE o.offer_category = 'sdCharacter'")
    Long findSdCharacterCount(Pager pager);

    @Query("SELECT o FROM OfferEntity o WHERE o.offer_category = 'sdCharacter'")
    List<OfferEntity> getSdCharacterListWithPaging(Pager pager);

    @Query("SELECT o FROM OfferEntity o WHERE o.offer_category = 'virtual' ORDER BY o.offer_no ASC")
    List<OfferEntity> findVirtual();

    @Query("SELECT COUNT(o) FROM OfferEntity o WHERE o.offer_category = 'virtual'")
    Long findVirtualCount(Pager pager);

    @Query("SELECT o FROM OfferEntity o WHERE o.offer_category = 'virtual'")
    List<OfferEntity> getVirtualListWithPaging(Pager pager);

    @Query("SELECT o FROM OfferEntity o WHERE o.offer_category = 'camaraMan' ORDER BY o.offer_no ASC")
    List<OfferEntity> findCamaraMan();

    @Query("SELECT COUNT(o) FROM OfferEntity o WHERE o.offer_category = 'camaraMan'")
    Long findCamaraManCount(Pager pager);

    @Query("SELECT o FROM OfferEntity o WHERE o.offer_category = 'camaraMan'")
    List<OfferEntity> getCamaraManListWithPaging(Pager pager);



    @Query("SELECT o FROM OfferEntity o WHERE o.offer_no = :offer_no")
    OfferEntity getOffer(@Param("offer_no") Long offer_no);



    @Modifying
    @Query("DELETE FROM OfferEntity o WHERE o.offer_no = :offer_no")
    void deleteOffer(Long offer_no);


    @Modifying
    @Query("UPDATE OfferEntity o SET o.offer_category = :#{#offerEntity.offer_category}, o.offer_company = :#{#offerEntity.offer_company}, o.offer_title = :#{#offerEntity.offer_title}, o.offer_career = :#{#offerEntity.offer_career}, o.offer_tools = :#{#offerEntity.offer_tools}, o.offer_type = :#{#offerEntity.offer_type}, o.offer_salary = :#{#offerEntity.offer_salary}, o.offer_content = :#{#offerEntity.offer_content}, o.offer_address = :#{#offerEntity.offer_address}, o.regDate = current_timestamp WHERE o.offer_no = :#{#offerEntity.offer_no}")
    void updateOffer(@Param("offerEntity") OfferEntity offerEntity);




}
