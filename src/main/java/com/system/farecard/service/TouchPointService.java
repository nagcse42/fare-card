package com.system.farecard.service;

import com.system.farecard.entity.TouchPointDetails;
import com.system.farecard.pojo.JourneyFlow;

import java.util.List;

public interface TouchPointService {
    void saveTouchPoint(TouchPointDetails touchPointDetails);
    void updateTouchPointDetails(TouchPointDetails touchPointDetails);
    List<TouchPointDetails> transformAndSaveFlow(JourneyFlow journeyFlow);
}
