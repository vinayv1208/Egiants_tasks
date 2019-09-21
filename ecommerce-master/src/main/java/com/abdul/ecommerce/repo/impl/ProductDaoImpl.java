package com.abdul.ecommerce.repo.impl;

/**
 * Created by abdul on 9/9/17.
 */

import com.abdul.ecommerce.repo.model.Product;
import com.abdul.ecommerce.repo.ProductDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ProductDaoImpl implements ProductDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void saveProduct(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product getProduct(int id) {
        return entityManager.find(Product.class,id);
    }
}
