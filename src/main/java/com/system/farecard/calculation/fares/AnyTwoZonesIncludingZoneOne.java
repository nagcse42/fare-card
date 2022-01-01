package com.system.farecard.calculation.fares;

import com.system.farecard.calculation.FareCalculationRule;
import com.system.farecard.constants.ZoneConstants;
import com.system.farecard.entity.StationDetails;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnyTwoZonesIncludingZoneOne implements FareCalculationRule {

    Set<String> otherZones = new HashSet<String>(Arrays.asList(ZoneConstants.ZONE_2, ZoneConstants.ZONE_3));

    @Override
    public boolean isFareMatched(StationDetails origin, StationDetails destination) {
        List<String> entryZone = Arrays.asList(origin.getZones().split(","));
        List<String> exitZone = Arrays.asList(destination.getZones().split(","));

        return (entryZone.contains(ZoneConstants.ZONE_1) || exitZone.contains(ZoneConstants.ZONE_1))
                && (otherZones.contains(origin.getZones()) || otherZones.contains(destination.getZones()));
    }

    @Override
    public double getFarePrice() {
        return 3;
    }
}