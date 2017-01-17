package com.raul.stopwatch;

/**
 * Created by Raul on 1/16/17.
 */

public class StopwatchThread extends Thread {

    private StopwatchView mStopwatchView;
    private long mStartTime;
    private boolean isRunning;
    private boolean isPaused;
    private long mElapsedTime;

    public StopwatchThread(StopwatchView stopwatchView, long elapsedTime) {
        isRunning = true;
        isPaused = false;
        mStopwatchView = stopwatchView;
        mElapsedTime = elapsedTime;
    }

    @Override
    public void run() {
        super.run();
        mStartTime = System.currentTimeMillis();
        while (isRunning) {
            if (!isPaused) {
                mStopwatchView.displayTime(System.currentTimeMillis() - mStartTime + mElapsedTime);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void pause() {
        this.isPaused = true;
    }

    public void reset() {
        this.isRunning = false;
        mStopwatchView.displayTime(0);
    }
}
