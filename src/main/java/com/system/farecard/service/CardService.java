package com.system.farecard.service;

import com.system.farecard.entity.CardDetails;
import com.system.farecard.enums.ValidationError;

public interface CardService {
    ValidationError validateCard(CardDetails cardDetails);
    CardDetails fetchCardDetails(String cardNumber);
    void saveCardDetails(CardDetails cardDetails);
    void updateCardDetails(CardDetails cardDetails);
}
