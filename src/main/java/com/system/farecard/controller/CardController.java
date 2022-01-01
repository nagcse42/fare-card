package com.system.farecard.controller;

import com.system.farecard.entity.CardDetails;
import com.system.farecard.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("card/{cardNumber}")
    public ResponseEntity fetchStationDetailsByName(@PathVariable String cardNumber) {
        CardDetails cardDetails;
        try {
            cardDetails = cardService.fetchCardDetails(cardNumber);
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }

        return ResponseEntity.ok(cardDetails);
    }
}
