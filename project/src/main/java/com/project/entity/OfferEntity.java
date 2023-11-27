package com.project.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "job_offer")  // Specify the table name in the database
public class OfferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "offer_seq")
    @SequenceGenerator(name = "offer_seq", sequenceName = "offer_seq", allocationSize = 1)
    @Column(name = "offer_no")
    private Long offer_no;

    @Column(name = "offer_category")
    private String offer_category;

    @Column(name = "offer_company")
    private String offer_company;

    @Column(name = "offer_title")
    private String offer_title;

    @Column(name = "offer_career")
    private String offer_career;

    @Column(name = "offer_tools")
    private String offer_tools;

    @Column(name = "offer_type")
    private String offer_type;

    @Column(name = "offer_salary")
    private Long offer_salary;

    @Column(name = "offer_content")
    private String offer_content;

    @Column(name = "REGDATE")
    private LocalDateTime regDate;

    @PrePersist
    protected void onCreate() {
        regDate = LocalDateTime.now();
    }


    @Column(name = "offer_address")
    private String offer_address;

    @Column(name = "user_no")
    private Long user_no;

    // Corrected method names
    public String getOffer_category() {
        return offer_category;
    }

    public Long getUser_no() {
        return user_no;
    }

    public void setUser_no(Long user_no) {
        this.user_no = user_no;
    }
}
