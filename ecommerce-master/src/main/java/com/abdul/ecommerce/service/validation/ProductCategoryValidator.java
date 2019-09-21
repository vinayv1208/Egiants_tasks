package com.abdul.ecommerce.service.validation;

import com.abdul.ecommerce.api.dto.ProductCategoryDto;
import com.abdul.ecommerce.repo.ProductCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by abdul on 9/11/17.
 */

public class ProductCategoryValidator implements ServiceValidator<ProductCategoryDto> {
    @Autowired
    ProductCategoryDao productCategoryDao;

    @Override
    public boolean isValid(ProductCategoryDto productCategory){
        if (validName(productCategory.getName()))
                return true;
        else
            return false;
    }

    private boolean validName throws GenericException(String name){
        if(name !=null)
            return false;
        if(productCategoryDao.getProductCategoryByName(name) != null)
            return false;

        return true;
    }
}
