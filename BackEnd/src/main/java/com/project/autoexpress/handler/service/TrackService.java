package com.project.autoexpress.handler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.autoexpress.handler.dao.TrackDao;
import com.project.autoexpress.entity.ShippingOrder;

@Service
public class TrackService {

    @Autowired
    private TrackDao trackDao;

    public void trackOrder(String shippingOrderNumber) {
        trackDao.trackOrder(shippingOrderNumber);
    }
}
