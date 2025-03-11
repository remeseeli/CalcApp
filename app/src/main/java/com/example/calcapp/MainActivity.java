package com.example.calcapp;

import static java.lang.Math.round;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText inputOne, inputTwo;

    private TextView textResult;

    // irrerelevant as there is no listeners
    //private Button addBtn, subBtn, mulBtn, divBtn;

    double numOne, numTwo, calcResult;

    String resultString;
    // Initialize error messages
    String zeroDivision = "Cannot divide by zero.";

    String notNumberError = "Please input numbers.";
    // Format decimals to 5 decimals (I think this is acceptable for a simple calculator)
    DecimalFormat df = new DecimalFormat("#.#####");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.firstInputBox), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Connect input boxes, text field and buttons to UI
        inputOne = findViewById(R.id.inputBoxOne);
        inputTwo = findViewById(R.id.inputBoxTwo);
        textResult = findViewById(R.id.resultText);
        /* irrelevant as we have no listeners
        addBtn = findViewById(R.id.addBtn);
        subBtn = findViewById(R.id.subBtn);
        mulBtn = findViewById(R.id.mulBtn);
        divBtn = findViewById(R.id.divBtn);
        */
    }

    public void addition(View view) {
        try {
            // parse both inputs into doubles
            numOne = Double.parseDouble(String.valueOf(inputOne.getText()));
            numTwo = Double.parseDouble(String.valueOf(inputTwo.getText()));

            // perform calculation
            calcResult = numOne + numTwo;

            // format into decimals
            resultString = df.format(calcResult);
            // set textView to result
            textResult.setText(resultString);
        }
        // catch exception when inputs are empty or not numbers
        catch(NumberFormatException e) {
            textResult.setText(notNumberError);
        }
    }
    public void subtraction(View view) {
        try {
            numOne = Double.parseDouble(String.valueOf(inputOne.getText()));
            numTwo = Double.parseDouble(String.valueOf(inputTwo.getText()));

            calcResult = numOne - numTwo;

            resultString = df.format(calcResult);

            textResult.setText(resultString);
        }
        catch(NumberFormatException e) {
            textResult.setText(notNumberError);
        }
    }
    public void multiplication(View view) {
        try {
            numOne = Double.parseDouble(String.valueOf(inputOne.getText()));
            numTwo = Double.parseDouble(String.valueOf(inputTwo.getText()));

            calcResult = numOne * numTwo;

            resultString = df.format(calcResult);

            textResult.setText(resultString);
        }
        catch(NumberFormatException e) {
            textResult.setText(notNumberError);
        }
    }
    public void division(View view) {
        try {
            numOne = Double.parseDouble(String.valueOf(inputOne.getText()));
            numTwo = Double.parseDouble(String.valueOf(inputTwo.getText()));
            //if second number is 0, display error message
            if (numTwo == 0) {
                textResult.setText(zeroDivision);
            } else {
                // else perform division and display it
                calcResult = numOne / numTwo;
                resultString = df.format(calcResult);
                textResult.setText(resultString);
            }
        }
        catch(NumberFormatException e) {
            textResult.setText(notNumberError);
        }
    }

}