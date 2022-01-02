package com.system.farecard.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TOUCH_POINT_DETAILS")
public class TouchPointDetails {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "CARD_NUMBER")
    private String cardNumber;

    @Column(name = "CHANNEL")
    private String channel;

    @Column(name = "ENTRY_STATION")
    private String entryStation;

    @Column(name = "ENTRY_ZONE")
    private String entryZone;

    @Column(name = "EXIT_STATION")
    private String exitStation;

    @Column(name = "EXIT_ZONE")
    private String exitZone;

    @Column(name = "BALANCE")
    private double balance;

    @Column(name = "JOURNEY_AMOUNT")
    private double journeyAmount;

    @Column(name = "AFTER_JOURNEY_BALANCE")
    private double afterJourneyBalance;

    @CreatedDate
    @Column(name = "CREATED_TIME")
    private LocalDateTime createdTime;

    @LastModifiedDate
    @Column(name = "UPDATED_TIME")
    private LocalDateTime updatedTime;

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

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getEntryStation() {
        return entryStation;
    }

    public void setEntryStation(String entryStation) {
        this.entryStation = entryStation;
    }

    public String getEntryZone() {
        return entryZone;
    }

    public void setEntryZone(String entryZone) {
        this.entryZone = entryZone;
    }

    public String getExitStation() {
        return exitStation;
    }

    public void setExitStation(String exitStation) {
        this.exitStation = exitStation;
    }

    public String getExitZone() {
        return exitZone;
    }

    public void setExitZone(String exitZone) {
        this.exitZone = exitZone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getJourneyAmount() {
        return journeyAmount;
    }

    public void setJourneyAmount(double journeyAmount) {
        this.journeyAmount = journeyAmount;
    }

    public double getAfterJourneyBalance() {
        return afterJourneyBalance;
    }

    public void setAfterJourneyBalance(double afterJourneyBalance) {
        this.afterJourneyBalance = afterJourneyBalance;
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
