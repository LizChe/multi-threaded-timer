package com.codecool.timer.controller;

import com.codecool.timer.service.TimerService;
import com.codecool.timer.view.View;

public class TimerController {

    private TimerService timerService;
    private View view;

    public TimerController(TimerService timerService, View view) {
        this.timerService = timerService;
        this.view = view;
    }

    private void handleStartCommand(String[] intention) {
        String timerName = view.getTimerName(intention);
        timerService.handleStartTimer(timerName);
    }

    public void run() {
        String[] intention;
        String timerName;
        String command;

        boolean isRunning = true;
        while (isRunning) {
            view.printText("Command?");
            intention = view.getUserIntention();
            command = view.getCommand(intention);
            switch (command) {
                case "start":
                    handleStartCommand(intention);
                    break;
                default:
                    System.out.println("No such option.");
                    break;
            }
        }
    }
}