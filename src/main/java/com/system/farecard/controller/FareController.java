package com.system.farecard.controller;

import com.system.farecard.entity.TouchPointDetails;
import com.system.farecard.pojo.CardDetails;
import com.system.farecard.service.TouchPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FareController {

    @Autowired
    private TouchPointService touchPointService;

    @PostMapping("/fare/new")
    public CardDetails issueNewCard(@RequestParam Integer balance) {
        return new CardDetails("121", 0l);
    }

    @GetMapping("/fare/info/{cardNumber}")
    public CardDetails getCardInfo(@PathVariable String cardNumber) {
        return new CardDetails(cardNumber, 30l);
    }

    @PostMapping("/fare/touch/point")
    public ResponseEntity updateTouchPoint(@RequestParam TouchPointDetails touchPointDetails) {
        try {
            touchPointService.saveTouchPoint(touchPointDetails);
            return ResponseEntity.ok(touchPointDetails);
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());

        }

    }


}
