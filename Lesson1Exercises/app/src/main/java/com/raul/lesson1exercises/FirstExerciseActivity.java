package com.raul.lesson1exercises;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_exercise);

        final EditText monthField = (EditText) findViewById(R.id.month_field);
        final TextView monthTextView = (TextView) findViewById(R.id.month);
        Button getMonthButton = (Button) findViewById(R.id.get_month);

        getMonthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String month;
                int monthNumber = Integer.parseInt(monthField.getText().toString());

                switch (monthNumber) {
                    case 1:
                        month = getString(R.string.january);
                        break;
                    case 2:
                        month = getString(R.string.february);
                        break;
                    case 3:
                        month = getString(R.string.march);
                        break;
                    case 4:
                        month = getString(R.string.april);
                        break;
                    case 5:
                        month = getString(R.string.may);
                        break;
                    case 6:
                        month = getString(R.string.june);
                        break;
                    case 7:
                        month = getString(R.string.july);
                        break;
                    case 8:
                        month = getString(R.string.august);
                        break;
                    case 9:
                        month = getString(R.string.september);
                        break;
                    case 10:
                        month = getString(R.string.october);
                        break;
                    case 11:
                        month = getString(R.string.november);
                        break;
                    case 12:
                        month = getString(R.string.december);
                        break;
                    default:
                        month = getString(R.string.wrong_number);
                        break;
                }
                monthTextView.setText(getString(R.string.month_result, month));
            }
        });
    }
}
