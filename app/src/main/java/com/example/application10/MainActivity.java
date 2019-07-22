package com.example.application10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText result;
    private EditText number;
    private TextView operation;

    private Double operand1 = null;
    private String newOp = "=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.res);
        number = findViewById(R.id.num);
        operation = findViewById(R.id.textView2);

        //Initialize operand buttons
        Button button0 = findViewById(R.id.button);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button decimal = findViewById(R.id.buttonDec);

        //Initialize operation buttons
        Button equals = findViewById(R.id.buttonEq);
        Button divide = findViewById(R.id.buttonDiv);
        Button multiply = findViewById(R.id.buttonMult);
        Button add = findViewById(R.id.buttonAdd);
        Button subtract = findViewById(R.id.buttonSub);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button clicked = (Button) view;
                number.append(clicked.getText().toString());
            }
        };

        //Set onClickListeners for operands
        button0.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        decimal.setOnClickListener(listener);

        View.OnClickListener opListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                String op = b.getText().toString();
                String num = number.getText().toString();
                try {
                    Double doubleVal = Double.valueOf(num);
                    performOp(doubleVal, op);
                } catch (NumberFormatException e) {
                    number.setText("");
                }
                newOp = op;
                operation.setText(newOp);
            }
        };

        //Set onClickListeners for operators
        equals.setOnClickListener(opListener);
        divide.setOnClickListener(opListener);
        multiply.setOnClickListener(opListener);
        add.setOnClickListener(opListener);
        subtract.setOnClickListener(opListener);

    }

    private void performOp(Double num, String op) {
        if (operand1 == null) operand1 = num;
        else {
            if (newOp.equals("=")) newOp = op;
            switch (newOp) {
                case "=":
                    operand1 = num;
                    break;
                case "/":
                    operand1 = (num == 0) ? 0.0 : operand1 / num;
                    break;
                case "*":
                    operand1 *= num;
                    break;
                case "-":
                    operand1 -= num;
                    break;
                case "+":
                    operand1 += num;
                    break;
            }

        }

        result.setText(operand1.toString());
        number.setText("");
    }
}