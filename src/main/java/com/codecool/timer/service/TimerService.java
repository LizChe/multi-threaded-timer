package com.codecool.timer.service;

import java.util.ArrayList;
import java.util.List;

import com.codecool.timer.model.Timer;

public class TimerService {

    private List<Timer> timers;

    public TimerService() {
        this.timers = new ArrayList<>();
    }

    public void handleStartTimer(String timerName) {
        Timer timer = new Timer(timerName);
        if (isStoppedTimer(timer)) {
            timers.remove(timer);
        }
        timers.add(timer);
    }

    private boolean isStoppedTimer(Timer timer) {
        return timers.contains(timer) && timers.get(timers.indexOf(timer)).isInterrupted();
    }
}