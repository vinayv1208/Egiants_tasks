package com.abdul.ecommerce.repo;

import com.abdul.ecommerce.repo.model.OrderDetails;
import com.abdul.ecommerce.repo.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by abdul on 9/2/17.
 */
public interface OrderDetailsDao extends CrudRepository<OrderDetails, Long> {
    void createOrder(OrderDetails orderDetails);
    List<OrderDetails> findAll();
    OrderDetails findOne(Long id);
    void save(Product product);
}
