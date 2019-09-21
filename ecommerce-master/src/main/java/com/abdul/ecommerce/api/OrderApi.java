package com.abdul.ecommerce.api;

import com.abdul.ecommerce.service.OrderService;
import com.abdul.ecommerce.repo.model.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by abdul on 9/3/17.
 */

@Path("/order")
public class OrderApi {
    @Autowired
    OrderService orderService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOrder(OrderDetails orderDetails){
        orderService.createOrder(orderDetails);

        return Response.status(200).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllOrders(){
        List<OrderDetails> orders = orderService.getAllOrders();

        return Response.status(200).entity(orders).build();
    }
}
