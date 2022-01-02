package com.system.farecard.calculation;

import com.system.farecard.calculation.fares.*;
import com.system.farecard.constants.ZoneConstants;
import com.system.farecard.entity.StationDetails;
import com.system.farecard.entity.TouchPointDetails;
import com.system.farecard.pojo.JourneyDetails;
import com.system.farecard.pojo.JourneyFlow;
import com.system.farecard.service.TouchPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class FareCalculator {
    @Autowired
    private TouchPointService touchPointService;

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

    public double calculateFarePrice(StationDetails origin, StationDetails destination) {

        Optional<FareCalculationRule> fareCalRule = calculationRules.stream().filter(calculationRule -> calculationRule.isFareMatched(origin, destination))
                .findFirst();

        return fareCalRule.map(FareCalculationRule::getFarePrice).orElse(3.2);
    }

    public double calculateFareAmount(JourneyDetails journeyDetails) {
        if("Bus".equalsIgnoreCase(journeyDetails.getChannel())) {
            return 2;
        }

        if(null == journeyDetails.getExitZone() || "".equals(journeyDetails.getExitZone())) {
            return 3.2;
        }

        StationDetails entryStation = new StationDetails();
        entryStation.setZones(journeyDetails.getEntryZone());

        StationDetails exitStation = new StationDetails();
        exitStation.setZones(journeyDetails.getEntryZone());

       return calculateFarePrice(entryStation, exitStation);
    }

    public static void main(String args[]) {
        FareCalculator calculator = new FareCalculator();
        calculator.addRules();

        StationDetails origin = new StationDetails(1l, "", ZoneConstants.ZONE_1);
        StationDetails destination = new StationDetails(2l, "", ZoneConstants.ZONE_1);

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
