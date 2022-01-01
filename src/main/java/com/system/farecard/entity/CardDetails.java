package com.system.farecard.entity;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CARD_DETAILS")
public class CardDetails {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CARD_NUMBER")
    private String cardNumber;

    @Column(name = "ISSUED_PLACE")
    private String placeOfIssue;

    @Column(name = "BALANCE")
    private double balance;

    @CreatedDate
    @Column(name = "ISSUED_TIME")
    private LocalDateTime createdTime;

    @LastModifiedDate
    @Column(name = "UPDATED_TIME")
    private LocalDateTime updatedTime;

    public CardDetails(){}

    public CardDetails(Long id, String cardNumber, String placeOfIssue, double balance, LocalDateTime createdTime, LocalDateTime updatedTime) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.placeOfIssue = placeOfIssue;
        this.balance = balance;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getPlaceOfIssue() {
        return placeOfIssue;
    }

    public void setPlaceOfIssue(String placeOfIssue) {
        this.placeOfIssue = placeOfIssue;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }
}
