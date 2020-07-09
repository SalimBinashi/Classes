package com.example.classes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.classes.R;
import com.example.classes.apis.Accounts;
import com.example.classes.services.AccountsListener;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener, AccountsListener {
    // initialize views
    private EditText editTEmail, editTPassword, editTConfirmpassword;
    private Button btnRegister;
    // create an instance of class Accounts
    private Accounts accounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // view binding
        editTEmail = findViewById(R.id.editTEmail);
        editTPassword = findViewById(R.id.editTPassword);
        editTConfirmpassword = findViewById(R.id.editTConfirm);
        btnRegister = findViewById(R.id.btnRegister);

        // set up a listener for the Register button
        btnRegister.setOnClickListener(this);

        //initialize context of the Accounts class
        accounts = new Accounts();

        // set up a listener for the accounts class
        accounts.setAccountsListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view.equals(btnRegister)){
            // validate input
            if (validated()) {
                String email = editTEmail.getText().toString().trim();
                String password = editTPassword.getText().toString().trim();

                 // call the register method in the Accounts class
                accounts.register(email,password);

            }
        }

    }

    private boolean validated() {
        if (TextUtils.isEmpty(editTEmail.getText().toString().trim())) {
            Toast.makeText(this, "Kindly Enter Email", Toast.LENGTH_SHORT).show();
            editTEmail.setFocusable(true);
            return false;

        } else if (TextUtils.isEmpty(editTPassword.getText().toString().trim())) {
            Toast.makeText(this, "Kindly Enter Password", Toast.LENGTH_SHORT).show();
            editTPassword.setFocusable(true);
            return false;

        } else if (TextUtils.isEmpty(editTConfirmpassword.getText().toString().trim())) {
            Toast.makeText(this, "Kindly Confirm Password", Toast.LENGTH_SHORT).show();
            editTConfirmpassword.setFocusable(true);
            return false;

        } else if (!editTPassword.getText().toString().trim().equals(editTConfirmpassword.getText().toString().trim())) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            editTConfirmpassword.setFocusable(true);
            return false;

        } else
            return true;
    }

    @Override
    public void onSuccessLogin() {

    }

    @Override
    public void onLoginFailure() {

    }

    @Override
    public void onSuccessRegister() {
        //on successful registration
        Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
    }

    @Override
    public void onRegisterFailure() {
        // on register failure
        Toast.makeText(this, "An Error occured", Toast.LENGTH_SHORT).show();

    }
}