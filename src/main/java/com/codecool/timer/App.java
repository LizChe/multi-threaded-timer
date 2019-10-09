package com.codecool.timer;

import com.codecool.timer.controller.TimerController;
import com.codecool.timer.service.TimerService;
import com.codecool.timer.service.InputParserService;
import com.codecool.timer.view.TerminalView;

public class App {
    public static void main(String[] args) {
        TimerService timerService = new TimerService();
        InputParserService parserService = new InputParserService();
        TerminalView view = new TerminalView();
        TimerController timerController = new TimerController(timerService, parserService, view);
        timerController.run();
    }
}