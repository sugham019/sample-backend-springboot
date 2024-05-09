package com.example.demoshoppingsite.model.status;

public enum UserStatus implements ResponseStatus{

    USERNAME_EXISTS(1),
    PASSWORD_WRONG(2),
    USER_CREATED(3);

    private final int status;

    UserStatus(int i) {
        this.status = i;
    }

    @Override
    public int getStatus() {
        return status;
    }
}
