package com.abdul.ecommerce.util.Exceptions;

/**
 * Created by abdul on 9/12/17.
 */
public class GenericException extends Exception{
    private String  errorCode;
    private String message;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessae(String message) {
        this.message = message;
    }
}
