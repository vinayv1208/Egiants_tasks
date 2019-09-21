package com.abdul.ecommerce.test.dao;

import com.abdul.ecommerce.repo.model.OrderDetails;
import com.abdul.ecommerce.repo.OrderDetailsDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by abdul on 9/2/17.
 */


@SpringBootApplication
@RunWith(SpringRunner.class)
@ComponentScan("com.abdul")
@Transactional
@Rollback(value = true)
public class OrderDetailsDaoTest {

    @Autowired
    OrderDetailsDao orderDetailsDao;

    @Test
    public void testCreateOrder(){
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setValue(900);
        orderDetailsDao.save(orderDetails);
    }
}
