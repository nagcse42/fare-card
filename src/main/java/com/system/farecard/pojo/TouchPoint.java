package com.system.farecard.pojo;

public class TouchPoint {
    private String station;
    private String zone;

    public TouchPoint(){}

    public TouchPoint(String station, String zone) {
        this.station = station;
        this.zone = zone;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }
}
