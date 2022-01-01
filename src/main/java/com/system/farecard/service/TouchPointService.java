package com.system.farecard.service;

import com.system.farecard.entity.TouchPointDetails;

public interface TouchPointService {
    void saveTouchPoint(TouchPointDetails touchPointDetails);
    void updateTouchPointDetails(TouchPointDetails touchPointDetails);
}
