package com.example.demoshoppingsite.model;

import com.example.demoshoppingsite.model.status.ResponseStatus;

public class Response {

    private ResponseStatus responseStatus;

    public Response(ResponseStatus status){
        this.responseStatus = status;
    }

    public ResponseStatus getResponseStatus(){
        return responseStatus;
    }
}
