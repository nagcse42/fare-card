package com.system.farecard.calculation.fares;

import com.system.farecard.calculation.FareCalculationRule;
import com.system.farecard.entity.StationDetails;

public class AnyThreeZones implements FareCalculationRule {

    @Override
    public boolean isFareMatched(StationDetails origin, StationDetails destination) {
        //TODO
        return false;
    }

    @Override
    public double getFarePrice() {
        return 0;
    }
}
