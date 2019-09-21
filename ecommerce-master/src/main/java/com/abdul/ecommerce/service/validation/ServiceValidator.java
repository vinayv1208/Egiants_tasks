package com.abdul.ecommerce.service.validation;

/**
 * Created by abdul on 9/11/17.
 */
public interface ServiceValidator<T> {
    boolean isValid(T t);
}
