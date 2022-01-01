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

    @Column(name = "TOUCH_POINT")
    private String touchPoint;

    @Column(name = "STATION")
    private String station;

    @Column(name = "ZONE")
    private int zone;

    @Column(name = "CHANNEL")
    private String channel;

    @CreatedDate
    @Column(name = "CREATED_TIME")
    private LocalDateTime createdTime;

    @LastModifiedDate
    @Column(name = "UPDATED_TIME")
    private LocalDateTime updatedTime;

    public TouchPointDetails(){}

    public TouchPointDetails(Long id, String cardNumber, String touchPoint, String station, int zone,
                             LocalDateTime createdTime, LocalDateTime updatedTime) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.touchPoint = touchPoint;
        this.station = station;
        this.zone = zone;
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

    public String getTouchPoint() {
        return touchPoint;
    }

    public void setTouchPoint(String touchPoint) {
        this.touchPoint = touchPoint;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
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
