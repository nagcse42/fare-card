package com.system.farecard.controller;

import com.system.farecard.entity.StationDetails;
import com.system.farecard.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StationDetailsController {

    @Autowired
    private StationService stationService;

    @GetMapping("/stations")
    public List<StationDetails> fetchStations() {
        return stationService.fetchStations();
    }

    @GetMapping("/stations/{stationName}")
    public List<StationDetails> fetchStationDetailsByName(@PathVariable String stationName) {
        return stationService.fetchStationByName(stationName);
    }
}
