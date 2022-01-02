package com.system.farecard.service.impl;

import com.system.farecard.entity.TouchPointDetails;
import com.system.farecard.jpa.CardDetailsRepository;
import com.system.farecard.jpa.TouchPointRepository;
import com.system.farecard.pojo.JourneyFlow;
import com.system.farecard.service.TouchPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouchPointServiceImpl implements TouchPointService {

    @Autowired
    private TouchPointRepository touchPointRepository;

    @Autowired
    private CardDetailsRepository cardDetailsRepository;

    @Override
    public void saveTouchPoint(TouchPointDetails touchPointDetails) {
        touchPointRepository.save(touchPointDetails);
    }

    @Override
    public void updateTouchPointDetails(TouchPointDetails touchPointDetails) {
        touchPointRepository.save(touchPointDetails);
    }

    @Override
    public List<TouchPointDetails> transformAndSaveFlow(JourneyFlow journeyFlow) {
        TouchPointDetails touchPointDetails = new TouchPointDetails();
        touchPointDetails.setAfterJourneyBalance(journeyFlow.getAfterJourneyBalance());
        touchPointDetails.setBalance(journeyFlow.getBalance());
        touchPointDetails.setCardNumber(journeyFlow.getCardNumber());
        touchPointDetails.setChannel(journeyFlow.getChannel());
        touchPointDetails.setEntryStation(journeyFlow.getEntryPoint().getStation());
        touchPointDetails.setEntryZone(journeyFlow.getEntryPoint().getZone());
        touchPointDetails.setExitStation(journeyFlow.getExitPoint().getStation());
        touchPointDetails.setExitZone(journeyFlow.getExitPoint().getZone());
        touchPointDetails.setJourneyAmount(journeyFlow.getJourneyAmount());

        saveTouchPoint(touchPointDetails);
        cardDetailsRepository.updateCardBalance(journeyFlow.getCardNumber(), journeyFlow.getAfterJourneyBalance());

        return touchPointRepository.findByCardNumber(journeyFlow.getCardNumber());
    }
}
