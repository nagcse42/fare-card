package com.system.farecard.service.impl;

import com.system.farecard.entity.CardDetails;
import com.system.farecard.enums.ValidationError;
import com.system.farecard.jpa.CardDetailsRepository;
import com.system.farecard.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardDetailsRepository cardRepository;

    @Override
    public ValidationError validateCard(CardDetails cardDetails) {
        if(null == cardDetails) {
            return ValidationError.INVALID_CARD;
        } else if(cardDetails.getBalance() <= 3.2){
            return ValidationError.INSUFFICIENT_BALANCE;
        }

        return null;
    }

    @Override
    public CardDetails fetchCardDetails(String cardNumber) {
        CardDetails cardDetails = cardRepository.findByCardNumber(cardNumber);
        ValidationError validationError = validateCard(cardDetails);

        if(null != validationError){
            throw new RuntimeException(validationError.name());
        }

        return cardDetails;
    }

    @Override
    public void saveCardDetails(CardDetails cardDetails) {

    }

    @Override
    public void updateCardDetails(CardDetails cardDetails) {

    }
}
