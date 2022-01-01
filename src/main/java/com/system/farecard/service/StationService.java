package com.system.farecard.service;

import com.system.farecard.entity.StationDetails;

import java.util.List;

public interface StationService {
    List<StationDetails> fetchStations();
    List<StationDetails> fetchStationByName(String name);
}
