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

    private Button addBtn, subBtn, mulBtn, divBtn;

    double numOne, numTwo, calcResult;

    String resultString;
    String zeroDivision = "Cannot divide by zero.";

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

        inputOne = findViewById(R.id.inputBoxOne);
        inputTwo = findViewById(R.id.inputBoxTwo);
        textResult = findViewById(R.id.resultText);
        addBtn = findViewById(R.id.addBtn);
        subBtn = findViewById(R.id.subBtn);
        mulBtn = findViewById(R.id.mulBtn);
        divBtn = findViewById(R.id.divBtn);
    }

    public void addition(View view) {
        numOne = Double.parseDouble(String.valueOf(inputOne.getText()));
        numTwo = Double.parseDouble(String.valueOf(inputTwo.getText()));
        calcResult = numOne + numTwo;
        resultString = df.format(calcResult);
        textResult.setText(resultString);
    }
    public void subtraction(View view) {
        numOne = Double.parseDouble(String.valueOf(inputOne.getText()));
        numTwo = Double.parseDouble(String.valueOf(inputTwo.getText()));
        calcResult = numOne - numTwo;
        resultString = df.format(calcResult);
        textResult.setText(resultString);
    }
    public void multiplication(View view) {
        numOne = Double.parseDouble(String.valueOf(inputOne.getText()));
        numTwo = Double.parseDouble(String.valueOf(inputTwo.getText()));
        calcResult = numOne * numTwo;
        resultString = df.format(calcResult);
        textResult.setText(resultString);
    }
    public void division(View view) {
        numOne = Double.parseDouble(String.valueOf(inputOne.getText()));
        numTwo = Double.parseDouble(String.valueOf(inputTwo.getText()));
        if (numTwo == 0) {
            textResult.setText(zeroDivision);
        } else {
            calcResult = numOne / numTwo;
            resultString = df.format(calcResult);
            textResult.setText(resultString);
        }
    }

}