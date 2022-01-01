package com.system.farecard.service;

import com.system.farecard.pojo.CardDetails;

import java.util.List;

public interface FareService {
    CardDetails issueCard();
    CardDetails fetchCardInfo();
    List<CardDetails> getAllCards();
}
