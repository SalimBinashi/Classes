package com.example.classes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.classes.R;
import com.example.classes.apis.Accounts;
import com.example.classes.apis.MathsAPI;
import com.example.classes.services.MathsAPIListener;

public class MathsActivity extends AppCompatActivity implements View.OnClickListener, MathsAPIListener {

    // initialize views
    private EditText editTFirstnumber, editTSecondnumber;
    private Button btnSum, btnProduct;
    private MathsAPI mathsAPI;
    private TextView textAnswer;
    Accounts accounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths);

        // view binding
        editTFirstnumber = findViewById(R.id.editTFirstNumber);
        editTSecondnumber = findViewById(R.id.editTSecondNumber);
        textAnswer = findViewById(R.id.textAnswer);
        btnSum = findViewById(R.id.btnSum);
        btnProduct = findViewById(R.id.btnProduct);
        // listening to onclick events
        btnSum.setOnClickListener(this);
        btnProduct.setOnClickListener(this);
        // creating an instance of the Maths Api
        mathsAPI = new MathsAPI();
        mathsAPI.setMathsAPIListener(this);
        // create an instance of Accounts class
        accounts = new Accounts();

    }

    @Override
    public void onClick(View view) {
        if (view.equals(btnSum)){
            // calling maths endpoint
            if (validated()){
                String firstNumber = editTFirstnumber.getText().toString().trim();
                String secondNumber = editTSecondnumber.getText().toString().trim();

                int num1 = Integer.parseInt(firstNumber);
                int num2 = Integer.parseInt(secondNumber);
                mathsAPI.sum(num1, num2);

            }

        } else if (view.equals(btnProduct)){
            // calling maths endpoint
            if (validated()){
                String firstNumber = editTFirstnumber.getText().toString().trim();
                String secondNumber = editTSecondnumber.getText().toString().trim();

                int num1 = Integer.parseInt(firstNumber);
                int num2 = Integer.parseInt(secondNumber);
                mathsAPI.product(num1, num2);

            }
        }
    }

    private boolean validated() {
        if (TextUtils.isEmpty(editTFirstnumber.getText().toString().trim())){
            Toast.makeText(this, "First Number cannot be empty!", Toast.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(editTSecondnumber.getText().toString().trim())){
            Toast.makeText(this, "First Number cannot be empty!", Toast.LENGTH_SHORT).show();
            return false;

        } else return true;
    }

    @Override
    public void onAnswerReceived(int answer) {
        // convert answer received
        textAnswer.setText(String.valueOf(answer));
    }
}