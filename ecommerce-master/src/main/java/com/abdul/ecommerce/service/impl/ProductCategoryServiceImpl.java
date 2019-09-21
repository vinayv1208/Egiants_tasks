package com.abdul.ecommerce.service.impl;

import com.abdul.ecommerce.api.dto.ProductCategoryDto;
import com.abdul.ecommerce.repo.model.ProductCategory;
import com.abdul.ecommerce.repo.ProductCategoryDao;
import com.abdul.ecommerce.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    ProductCategoryDao productCategoryDao;

    @Override
    public List<ProductCategoryDto> getAllProductCategories() {
        List<ProductCategoryDto> productCategories = new LinkedList();

        for(ProductCategory productCategory: productCategoryDao.getAllProductCategories()){
            productCategories.add(new ProductCategoryDto(productCategory.getName()));
        }

        return productCategories;
    }

    @Override
    public ProductCategory getProductCategoryByName(String name) {
        return productCategoryDao.getProductCategoryByName(name);
    }

    @Override
    public void createProductCategory(ProductCategoryDto productCategory) {
        productCategoryDao.createProductCategory(new ProductCategory(productCategory.getName()));
    }
}
