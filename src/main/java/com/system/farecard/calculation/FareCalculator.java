package com.system.farecard.calculation;

import com.system.farecard.calculation.fares.*;
import com.system.farecard.constants.ZoneConstants;
import com.system.farecard.entity.StationDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class FareCalculator {
    private final Set<FareCalculationRule> calculationRules;

    public FareCalculator(){
        calculationRules = new HashSet<>();
    }

    public FareCalculator(Set<FareCalculationRule> rules) {
        this.calculationRules = rules;
    }

    @PostConstruct
    private void addRules() {
        calculationRules.add(new AnyBusJourney());
        calculationRules.add(new AnywhereInZoneOne());
        calculationRules.add(new AnyOneZoneOutSideZoneOne());
        calculationRules.add(new AnyThreeZones());
        calculationRules.add(new AnyTwoZonesIncludingZoneOne());
        calculationRules.add(new AnyTwoZonesExcludingZoneOne());
    }

    protected double calculateFarePrice(StationDetails origin, StationDetails destination) {

        Optional<FareCalculationRule> fareCalRule = calculationRules.stream().filter(calculationRule -> calculationRule.isFareMatched(origin, destination))
                .findFirst();

        return fareCalRule.map(FareCalculationRule::getFarePrice).orElse(3.2);
    }

    public static void main(String args[]) {
        FareCalculator calculator = new FareCalculator();
        calculator.addRules();

        StationDetails origin = new StationDetails(1l, "", ZoneConstants.ZONE_2);
        StationDetails destination = new StationDetails(2l, "", ZoneConstants.ZONE_2);

        double price = calculator.calculateFarePrice(origin, destination);
        System.out.println("Anywhere in zone 1 expected price: 2.5 and actual: "+price);

        destination.setZones(ZoneConstants.ZONE_2);
        origin.setZones(ZoneConstants.ZONE_2);
        price = calculator.calculateFarePrice(origin, destination);
        System.out.println("Any one zone outside zone 1 expected price: 2 and actual: "+price);

        destination.setZones(ZoneConstants.ZONE_1);
        origin.setZones(ZoneConstants.ZONE_2);
        price = calculator.calculateFarePrice(origin, destination);
        System.out.println("Any two zones including zone 1 expected price: 3 and actual: "+price);

        destination.setZones(ZoneConstants.ZONE_3);
        origin.setZones(ZoneConstants.ZONE_2);
        price = calculator.calculateFarePrice(origin, destination);
        System.out.println("Any two zones excluding zone 1 expected price: 2.25 and actual: "+price);
    }
}
