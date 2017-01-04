package com.raul.lesson1exercises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        TextView firstExercise = (TextView) findViewById(R.id.first_exercise);
        TextView secondExercise = (TextView) findViewById(R.id.second_exercise);
        TextView thirdExercise = (TextView) findViewById(R.id.third_exercise);

        firstExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent firstExerciseIntent = new Intent(MainActivity.this, FirstExerciseActivity.class);
                startActivity(firstExerciseIntent);
            }
        });

        secondExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondExerciseIntent = new Intent(MainActivity.this, SecondExerciseActivity.class);
                startActivity(secondExerciseIntent);
            }
        });

        thirdExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent thirdExerciseIntent = new Intent(MainActivity.this, ThirdExerciseActivity.class);
                startActivity(thirdExerciseIntent);
            }
        });
    }
}
