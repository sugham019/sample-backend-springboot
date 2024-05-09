package com.example.demoshoppingsite.model;

import com.example.demoshoppingsite.model.status.ResponseStatus;

public class ResponseObj<T> extends Response{
    private T object;


    public ResponseObj(ResponseStatus status) {
        super(status);
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
