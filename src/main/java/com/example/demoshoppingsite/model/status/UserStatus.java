package com.example.demoshoppingsite.model.status;

public enum UserStatus implements ResponseStatus{

    USER_EXISTS(1),
    USER_DOESNT_EXIST(2),
    USER_CREATED(3),
    PASSWORD_WRONG(4),
    USERNAME_WRONG(5),
    CORRECT_INFORMATION(6),
    PASSWORD_UPDATED(7),
    ACCOUNT_DELETED(8);

    private final int status;

    UserStatus(int i) {
        this.status = i;
    }

    @Override
    public int getStatus() {
        return status;
    }
}
