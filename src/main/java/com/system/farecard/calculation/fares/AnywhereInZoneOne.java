package com.system.farecard.calculation.fares;

import com.system.farecard.calculation.FareCalculationRule;
import com.system.farecard.constants.ZoneConstants;
import com.system.farecard.entity.StationDetails;

import java.util.Arrays;
import java.util.List;

public class AnywhereInZoneOne implements FareCalculationRule {

    @Override
    public boolean isFareMatched(StationDetails origin, StationDetails destination) {
        List<String> entryZone = Arrays.asList(origin.getZones().split(","));
        List<String> exitZone = Arrays.asList(destination.getZones().split(","));

        return entryZone.contains(ZoneConstants.ZONE_1) && exitZone.contains(ZoneConstants.ZONE_1);
    }

    @Override
    public double getFarePrice() {
        return 2.5;
    }
}
