package com.system.farecard.service;

import com.system.farecard.entity.TouchPointDetails;
import com.system.farecard.pojo.JourneyFlow;

public interface TouchPointService {
    void saveTouchPoint(TouchPointDetails touchPointDetails);
    void updateTouchPointDetails(TouchPointDetails touchPointDetails);
    void transformAndSaveFlow(JourneyFlow journeyFlow);
}
