package com.example.demoshoppingsite.model.status;

public enum ProductStatus implements ResponseStatus{
    AVAILABLE(1), NOT_AVAILABLE(2), OUT_OF_STOCK(3);

    private final int status;

    ProductStatus(int status){
        this.status = status;
    }

    @Override
    public int getStatus() {
        return status;
    }
}
