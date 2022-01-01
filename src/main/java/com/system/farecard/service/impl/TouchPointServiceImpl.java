package com.system.farecard.service.impl;

import com.system.farecard.entity.TouchPointDetails;
import com.system.farecard.jpa.TouchPointRepository;
import com.system.farecard.service.TouchPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TouchPointServiceImpl implements TouchPointService {

    @Autowired
    private TouchPointRepository touchPointRepository;

    @Override
    public void saveTouchPoint(TouchPointDetails touchPointDetails) {
        touchPointRepository.save(touchPointDetails);
    }

    @Override
    public void updateTouchPointDetails(TouchPointDetails touchPointDetails) {
        touchPointRepository.save(touchPointDetails);
    }
}
