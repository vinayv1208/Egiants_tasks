package com.abdul.ecommerce.api;

import com.abdul.ecommerce.api.dto.ProductCategoryDto;
import com.abdul.ecommerce.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by abdul on 9/11/17.
 */

@Path("/productcategory")
public class ProductCategoryApi {
    @Autowired
    ProductCategoryService productCategoryService;

    @GET
    public Response getAllProductCategories(){
        List<ProductCategoryDto> productCategories = productCategoryService.getAllProductCategories();

        return Response.status(200).entity(productCategories).build();
    }

    @POST
    public Response createProductCategory(ProductCategoryDto productCategoryDto) {
        productCategoryService.createProductCategory(productCategoryDto);

        return Response.status(200).build();
    }
}
