package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private int firstOperand;
    private int secondOperand;
    private boolean isOperationClick;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);

    }

    public void oneNumberClick(View view) {


        if (view.getId() == R.id.btn_clear) {
            textView.setText("0");
        } else {
            String text = ((MaterialButton) view).getText().toString();
            if (textView.getText().toString().equals("0") || isOperationClick) {
                textView.setText(text);
            } else {
                textView.append(text);
            }
            isOperationClick = false;

        }
    }

    public void oneOperationClick(View view) {
        String currentText = textView.getText().toString();
        isOperationClick = true;

        if (view.getId() == R.id.bt_plus) {
            firstOperand = Integer.parseInt(currentText);
            operator = "+";
        } else if (view.getId() == R.id.bt_minus) {
            firstOperand = Integer.parseInt(currentText);
            operator = "-";
        } else if (view.getId() == R.id.bt_division) {
            firstOperand = Integer.parseInt(currentText);
            operator = "/";
        } else if (view.getId() == R.id.bt_multiplication) {
            firstOperand = Integer.parseInt(currentText);
            operator = "*";
        } else if (view.getId() == R.id.bt_equal) {
            secondOperand = Integer.parseInt(currentText);
            int result = calculateResult(firstOperand, secondOperand, operator);
            textView.setText(String.valueOf(result));
            isOperationClick = false;



        }
    }

    private int calculateResult(int firstOperand, int secondOperand, String operator) {
        switch (operator) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "/":
                if (secondOperand != 0) {
                    return firstOperand / secondOperand;
                } else {
                    return 0;
                }
            case "*":
                return firstOperand * secondOperand;
            default:
                return 0;
        }
    }
}