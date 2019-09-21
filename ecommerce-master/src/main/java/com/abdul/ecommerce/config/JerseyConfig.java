package com.abdul.ecommerce.config;

import com.abdul.ecommerce.api.OrderApi;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        this.register(HelloResource.class);
        this.register(OrderApi.class);
    }
}
