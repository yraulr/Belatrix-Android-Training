package com.raul.lesson1exercises;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_exercise);

        final EditText firstNumberField = (EditText) findViewById(R.id.first_number_field);
        final EditText operatorField = (EditText) findViewById(R.id.operator_field);
        final EditText secondNumberField = (EditText) findViewById(R.id.second_number_field);
        final TextView resultTextView = (TextView) findViewById(R.id.result);
        Button submitButton = (Button) findViewById(R.id.submit);

        resultTextView.setText(getString(R.string.result, "-"));
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstNumber = firstNumberField.getText().toString();
                String operator = operatorField.getText().toString();
                String secondNumber = secondNumberField.getText().toString();

                if (firstNumber.isEmpty() || operator.isEmpty() || secondNumber.isEmpty()) {
                    Toast.makeText(
                            SecondExerciseActivity.this,
                            getString(R.string.missing_data),
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                double firstNumberValue = Double.parseDouble(firstNumber);
                double secondNumberValue = Double.parseDouble(secondNumber);
                String result;

                switch (operator) {
                    case "+":
                        result = String.valueOf(firstNumberValue + secondNumberValue);
                        break;
                    case "-":
                        result = String.valueOf(firstNumberValue - secondNumberValue);
                        break;
                    case "*":
                        result = String.valueOf(firstNumberValue * secondNumberValue);
                        break;
                    case "/":
                        result = String.valueOf(firstNumberValue / secondNumberValue);
                        break;
                    default:
                        result = "-";
                        break;
                }

                resultTextView.setText(getString(R.string.result, result));
            }
        });
    }
}
