package com.raul.stopwatch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements StopwatchView {

    /** Widgets */
    private TextView timeText;
    private Button startPauseButton;
    private Button resetButton;

    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("mm:ss:SS");
    private StopwatchThread stopwatchThread;
    private boolean isRunning;
    private long mElapsedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        timeText = (TextView) findViewById(R.id.time_text);
        startPauseButton = (Button) findViewById(R.id.start_pause_button);
        resetButton = (Button) findViewById(R.id.reset_button);

        isRunning = false;
        mElapsedTime = 0;

        startPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isRunning) {
                    isRunning = true;
                    stopwatchThread = new StopwatchThread(MainActivity.this, mElapsedTime);
                    stopwatchThread.start();
                    startPauseButton.setText(R.string.pause);
                } else {
                    isRunning = false;
                    stopwatchThread.pause();
                    startPauseButton.setText(R.string.start);
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopwatchThread.reset();
            }
        });
    }

    @Override
    public void displayTime(final long timeInMilliseconds) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                timeText.setText(timeFormat.format(new Date(timeInMilliseconds)));
                mElapsedTime = timeInMilliseconds;
            }
        });
    }
}
