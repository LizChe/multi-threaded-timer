package com.codecool.timer.controller;

import com.codecool.timer.service.InputParserService;
import com.codecool.timer.service.TimerService;
import com.codecool.timer.view.TerminalView;

public class TimerController {

    private TimerService timerService;
    private InputParserService parserService;
    private TerminalView view;

    public TimerController(TimerService timerService, InputParserService parserService, TerminalView view) {
        this.timerService = timerService;
        this.parserService = parserService;
        this.view = view;
    }

    public void run() {
        String[] intention;
        String command;
        String userInput;

        boolean isRunning = true;
        while (isRunning) {
            view.printText("Command?");
            userInput = view.getUserInput();
            intention = parserService.getUserIntention(userInput);
            command = parserService.getExtractedCommandFrom(intention);
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
                case "exit":
                    handleCheckCommand();
                    isRunning = false;
                    break;
                default:
                    System.out.println("No such option.");
                    break;
            }
        }
    }

    private void handleStartCommand(String[] intention) {
        String timerName = parserService.getExtractedTimerNameFrom(intention);
        timerService.handleStartTimer(timerName);
    }

    private void handleCheckCommand() {
        timerService.handleCheckTimers();
        view.showTimers(timerService.getTimers());
    }

    private void handleStopCommand(String[] intention) {
        String timerName = parserService.getExtractedTimerNameFrom(intention);
        timerService.handleStopTimer(timerName);
    }
}