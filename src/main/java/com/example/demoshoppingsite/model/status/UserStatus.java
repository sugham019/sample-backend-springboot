package com.example.demoshoppingsite.model.status;

public enum UserStatus implements ResponseStatus{

    USERNAME_EXISTS(1),
    USER_CREATED(2),
    PASSWORD_WRONG(3),
    USERNAME_WRONG(4),
    CORRECT_INFORMATION(5);

    private final int status;

    UserStatus(int i) {
        this.status = i;
    }

    @Override
    public int getStatus() {
        return status;
    }
}
