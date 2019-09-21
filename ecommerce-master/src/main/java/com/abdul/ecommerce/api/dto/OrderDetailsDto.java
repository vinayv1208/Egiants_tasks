package com.abdul.ecommerce.api.dto;

/**
 * Created by abdul on 9/11/17.
 */
public class OrderDetailsDto {
    private Double value;
    private ReceiptDto receiptDto;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public ReceiptDto getReceiptDto() {
        return receiptDto;
    }

    public void setReceiptDto(ReceiptDto receiptDto) {
        this.receiptDto = receiptDto;
    }
}
