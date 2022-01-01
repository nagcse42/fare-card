package com.system.farecard.calculation;

import com.system.farecard.entity.StationDetails;

public interface FareCalculationRule {
    boolean isFareMatched(StationDetails origin, StationDetails destination);
    double getFarePrice();
}
