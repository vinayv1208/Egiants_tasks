package com.abdul.ecommerce.repo;

import com.abdul.ecommerce.repo.model.Product;

/**
 * Created by abdul on 9/9/17.
 */
public interface ProductDao {
    void saveProduct(Product product);
    Product getProduct(int id);
}
