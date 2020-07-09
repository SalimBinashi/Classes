package com.example.classes.services;

public interface AccountsListener {

    void onSuccessLogin();
    void onLoginFailure();
    void onSuccessRegister();
    void onRegisterFailure();
}
