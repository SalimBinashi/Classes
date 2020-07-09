package com.example.classes.apis;

import android.content.Context;

import com.example.classes.services.AccountsListener;

public class Accounts {
    private Context context;
    private AccountsListener accountsListener;

    //public Accounts(Context context) {
      //  this.context = context;
    //}

    // login function
    public void login(String email, String password){
        if (email.equals("abc@gmail.com") && password.equals("12345")){
            accountsListener.onSuccessLogin();
        } else {
            accountsListener.onLoginFailure();
            }

    }

    public void register(String email, String password) {

    }

    public AccountsListener getAccountsListener() {
        return accountsListener;
    }

    public void setAccountsListener(AccountsListener accountsListener) {
        this.accountsListener = accountsListener;
    }
}
