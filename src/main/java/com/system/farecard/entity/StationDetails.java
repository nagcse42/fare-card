package com.system.farecard.entity;

import javax.persistence.*;

@Entity
@Table(name = "STATION_DETAILS")
public class StationDetails {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ZONES")
    private String zones;

    public StationDetails(){}

    public StationDetails(Long id, String name, String zones) {
        this.id = id;
        this.name = name;
        this.zones = zones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZones() {
        return zones;
    }

    public void setZones(String zones) {
        this.zones = zones;
    }
}
