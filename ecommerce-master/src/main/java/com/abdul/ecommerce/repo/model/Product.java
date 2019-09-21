package com.abdul.ecommerce.repo.model;

import javax.persistence.*;

/**
 * Created by abdul on 9/9/17.
 */
@Entity
public class Product {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToOne(targetEntity = ProductCategory.class)
    @JoinColumn(name = "productcategory_id")
    private ProductCategory productCategory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}
