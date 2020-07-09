package com.example.classes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.classes.apis.Accounts;
import com.example.classes.services.AccountsListener;
import com.example.classes.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AccountsListener {
    EditText editTemail, editTPassword;
    Button btnLogin;

   private  Accounts accounts; // create an instance of the Accounts class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTemail = findViewById(R.id.editTEmail);
        editTPassword = findViewById(R.id.editTPassword);
        btnLogin = findViewById(R.id.btnLogin);

        //initialize context of the Accounts class
        accounts = new Accounts(); // changes the context of the class to the current class
        // listening to the AccountsListener interface
        accounts.setAccountsListener(this);



        // setting a listener to the login button
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.equals(btnLogin)){
            // validate credentials
            if (validated()){
                // login
                String email = editTemail.getText().toString();
                String password = editTPassword.getText().toString();

                accounts.login(email,password);



            }

        }

    }

    private boolean validated() {
        if (TextUtils.isEmpty(editTemail.getText().toString())) {
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(editTPassword.getText().toString())) {
            Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
            editTPassword.setFocusable(true);
            return false;
        } else if(!Patterns.EMAIL_ADDRESS.matcher(editTemail.getText().toString()).matches()){
            Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show();
            return false;
        } else
            return true;


    }

    @Override
    public void onSuccessLogin() {
        Toast.makeText(this, "Login Successfull", Toast.LENGTH_SHORT).show();
        // take user to another activity
        startActivity(new Intent(MainActivity.this, MathsActivity.class));
    }

    @Override
    public void onLoginFailure() {
        Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onSuccessRegister() {

    }

    @Override
    public void onRegisterFailure() {

    }
}