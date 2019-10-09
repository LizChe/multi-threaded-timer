package com.codecool.timer.model;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Timer implements Runnable {

    private String name;
    private Thread thread;
    private long startTime;
    private long endTime;
    private boolean isInterrupted;

    public Timer(String name) {
        this.name = name;
        thread = new Thread(this, name);
        thread.start();
    }

    public String getName() {
        return name;
    }

    public boolean isInterrupted() {
        return isInterrupted;
    }

    private void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    private void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    private long getResetTime() {
        return System.nanoTime();
    }

    private long getElapsedTime(long startTime, long endTime) {
        long elapsedTime = endTime - startTime;
        return TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
    }

    private synchronized boolean isRunning() {
        return !this.isInterrupted;
    }

    @Override
    public void run() {
        if (isRunning()) {
            startTime = getResetTime();
            setStartTime(startTime);
        }
    }

    public synchronized void stop() {
        endTime = getResetTime();
        setEndTime(endTime);
        this.isInterrupted = true;
    }

    public void updateStopTime() {
        if (!isInterrupted) {
            endTime = getResetTime();
            setEndTime(endTime);
        }
    }

    @Override
    public String toString() {
        return "Name: " + name
                + " Thread: " + thread.getId()
                + " Seconds: " + getElapsedTime(startTime, endTime)
                + " Interrupted: " + isInterrupted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timer timer = (Timer) o;
        return name.equals(timer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}