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

    public void run() {
        String[] intention;
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
                case "check":
                    handleCheckCommand();
                    break;
                case "stop":
                    handleStopCommand(intention);
                    break;
                default:
                    System.out.println("No such option.");
                    break;
            }
        }
    }

    private void handleStartCommand(String[] intention) {
        String timerName = view.getTimerName(intention);
        timerService.handleStartTimer(timerName);
    }

    private void handleCheckCommand() {
        timerService.handleCheckTimers();
        view.showTimers(timerService.getTimers());
    }

    private void handleStopCommand(String[] intention) {
        String timerName = view.getTimerName(intention);
        timerService.handleStopTimer(timerName);
    }
}