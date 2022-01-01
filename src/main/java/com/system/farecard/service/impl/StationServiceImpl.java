package com.system.farecard.service.impl;

import com.system.farecard.entity.StationDetails;
import com.system.farecard.jpa.StationDetailsRepository;
import com.system.farecard.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImpl implements StationService {

    @Autowired
    private StationDetailsRepository stationDetailsRepository;

    @Override
    public List<StationDetails> fetchStations() {
        return stationDetailsRepository.findAll();
    }

    @Override
    public List<StationDetails> fetchStationByName(String name) {
        return stationDetailsRepository.findByName(name);
    }
}
