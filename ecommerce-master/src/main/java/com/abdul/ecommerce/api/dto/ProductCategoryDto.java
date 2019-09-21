package com.abdul.ecommerce.api.dto;

/**
 * Created by abdul on 9/11/17.
 */
public class ProductCategoryDto {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategoryDto(String name){this.setName(name);}
}
