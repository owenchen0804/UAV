package com.project.autoexpress.handler.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.autoexpress.entity.ShippingOrder;

@Repository
public class TrackDao {

    @Autowired
    private SessionFactory sessionFactory;

    public ShippingOrder trackOrder(String shippingOrderNumber) {
        ShippingOrder shippingOrder = null;

        try (Session session = sessionFactory.openSession()) {
            Criteria criteria = session.createCriteria(ShippingOrder.class);

            shippingOrder = (ShippingOrder) criteria.add(Restrictions.eq("id", shippingOrderNumber)).uniqueResult();


        } catch (Exception e) {
            e.printStackTrace();
        }

        if (shippingOrder != null) {
            return shippingOrder;
        }
        return null;

    }
}
