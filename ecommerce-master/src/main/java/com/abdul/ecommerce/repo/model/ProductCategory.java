package com.abdul.ecommerce.repo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by abdul on 9/9/17.
 */
@Entity
public class ProductCategory {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(mappedBy = "productCategory")
    private List<Product> products;

    public ProductCategory(){}

    public ProductCategory(String name){setName(name);}

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
