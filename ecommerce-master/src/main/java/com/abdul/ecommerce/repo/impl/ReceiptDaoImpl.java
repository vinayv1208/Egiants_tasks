package com.abdul.ecommerce.repo.impl;

import com.abdul.ecommerce.repo.model.OrderDetails;
import com.abdul.ecommerce.repo.model.Receipt;
import com.abdul.ecommerce.repo.ReceiptDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by abdul on 9/5/17.
 */
public class ReceiptDaoImpl implements ReceiptDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Receipt getReceipt(int id) {
        return entityManager.find(Receipt.class, id);
    }

    @Override
    public OrderDetails getReceiptOrder(int id){
        return entityManager.find(Receipt.class, id).getOrderDetails();
    }
}
