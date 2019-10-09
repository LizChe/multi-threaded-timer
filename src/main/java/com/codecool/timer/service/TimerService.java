package com.codecool.timer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public void handleStopTimer(String timerName) {
        Optional<Timer> timer = getTimerByName(timerName);
        timer.ifPresent(Timer::stop);
    }

    public void handleCheckTimers() {
        timers.forEach(Timer::updateStopTime);
        showTimers();
    }

    private Optional<Timer> getTimerByName(String timerName) {
        return timers.stream()
                .filter(timer -> timer.getName().equals(timerName))
                .findFirst();
    }

    private void showTimers() {
        timers.forEach(System.out::println);
    }

    private boolean isStoppedTimer(Timer timer) {
        return timers.contains(timer) && timers.get(timers.indexOf(timer)).isInterrupted();
    }
}