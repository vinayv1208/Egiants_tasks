package com.abdul.ecommerce.repo.impl;

import com.abdul.ecommerce.repo.model.ProductCategory;
import com.abdul.ecommerce.repo.ProductCategoryDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by abdul on 9/9/17.
 */
public class ProductCategoryDaoImpl implements ProductCategoryDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<ProductCategory> getAllProductCategories() {
        return entityManager.createQuery(
                "Select pc from ProductCategory pc", ProductCategory.class)
                .getResultList();
    }

    @Override
    public ProductCategory getProductCategoryByName(String name) {
        return entityManager.createQuery(
                "select pc from productcategory pc where pc.name = :name",
                ProductCategory.class).setParameter("name",name).getSingleResult();
    }

    @Override
    public void createProductCategory(ProductCategory productCategory) {
        entityManager.persist(productCategory);
    }
}
