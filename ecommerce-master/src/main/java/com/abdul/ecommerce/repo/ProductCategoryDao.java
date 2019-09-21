package com.abdul.ecommerce.repo;

import com.abdul.ecommerce.repo.model.ProductCategory;

import java.util.List;

/**
 * Created by abdul on 9/9/17.
 */
public interface ProductCategoryDao {
    List<ProductCategory> getAllProductCategories();
    ProductCategory getProductCategoryByName(String name);
    void createProductCategory(ProductCategory productCategory);
}
