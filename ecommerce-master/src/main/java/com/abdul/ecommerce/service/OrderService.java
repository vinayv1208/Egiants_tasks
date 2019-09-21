package com.abdul.ecommerce.service;

import com.abdul.ecommerce.repo.model.OrderDetails;

import java.util.List;

/**
 * Created by abdul on 9/2/17.
 */
public interface OrderService {
    void createOrder(OrderDetails orderDetails);
    List<OrderDetails> getAllOrders();
}
