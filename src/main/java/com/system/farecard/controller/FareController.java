package com.system.farecard.controller;

import com.system.farecard.calculation.FareCalculator;
import com.system.farecard.entity.TouchPointDetails;
import com.system.farecard.pojo.CardDetails;
import com.system.farecard.pojo.JourneyDetails;
import com.system.farecard.pojo.JourneyFlow;
import com.system.farecard.service.FareService;
import com.system.farecard.service.TouchPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FareController {

    @Autowired
    private TouchPointService touchPointService;

    @Autowired
    private FareService fareService;

    @Autowired
    private FareCalculator fareCalculator;

    @PostMapping("fare/new")
    public CardDetails issueNewCard(@RequestParam Integer balance) {
        return new CardDetails("121", 0l);
    }

    @GetMapping("fare/info/{cardNumber}")
    public CardDetails getCardInfo(@PathVariable String cardNumber) {
        return new CardDetails(cardNumber, 30l);
    }

    @PostMapping("fare/touch/point")
    public ResponseEntity updateTouchPoint(@RequestParam TouchPointDetails touchPointDetails) {
        try {
            touchPointService.saveTouchPoint(touchPointDetails);
            return ResponseEntity.ok(touchPointDetails);
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());

        }
    }

    @PostMapping(value = "fare/calculation",consumes = "application/json", produces = "application/json")
    public ResponseEntity calculateJourneyFare(@RequestBody JourneyDetails journeyDetails) {
        try {
            double journeyAmount = fareCalculator.calculateFareAmount(journeyDetails);
            return ResponseEntity.ok(journeyAmount);
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @PostMapping(value = "save/journey",consumes = "application/json", produces = "application/json")
    public ResponseEntity saveJourneyFlow(@RequestBody JourneyFlow journeyFlow) {
        try {
            List<TouchPointDetails> touchPointDetails = touchPointService.transformAndSaveFlow(journeyFlow);
            return ResponseEntity.ok(touchPointDetails);
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }
}
