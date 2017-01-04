package com.raul.lesson1exercises;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_exercise);

        final EditText linesField = (EditText) findViewById(R.id.lines_field);
        Button showLinesButton = (Button) findViewById(R.id.show_lines_button);
        final TextView linesTextView = (TextView) findViewById(R.id.lines_text_view);

        showLinesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int lines = Integer.parseInt(linesField.getText().toString());
                if (lines <= 0) {
                    Toast.makeText(
                            ThirdExerciseActivity.this,
                            getString(R.string.wrong_number),
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < lines; i++) {
                    builder.append(getString(R.string.line_number, i+1) + "\n");
                }
                linesTextView.setText(builder.toString());
            }
        });
    }
}
