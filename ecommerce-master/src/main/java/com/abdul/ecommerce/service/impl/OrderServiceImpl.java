package com.abdul.ecommerce.service.impl;

import com.abdul.ecommerce.api.dto.OrderDetailsDto;
import com.abdul.ecommerce.repo.model.OrderDetails;
import com.abdul.ecommerce.repo.OrderDetailsDao;
import com.abdul.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by abdul on 9/2/17.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDetailsDao orderDetailsDao;

    @Override
    public void createOrder(OrderDetails orderDetails){
        orderDetailsDao.save(orderDetails);
    }

    @Override
    public List getAllOrders(){
        List<OrderDetails> orders = orderDetailsDao.findAll();

        List<OrderDetailsDto> orderDetailsDtosList = new ArrayList<OrderDetailsDto>();

        for(OrderDetails orderDetails: orders){
            OrderDetailsDto orderDetailsDto = new OrderDetailsDto();

            orderDetailsDto.setValue(orderDetails.getValue());
            orderDetailsDto.getReceiptDto().setText(orderDetails.getReceipt().getText());

        }

        return orders;
    }
}
