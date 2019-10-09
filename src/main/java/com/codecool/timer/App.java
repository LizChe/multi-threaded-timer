package com.codecool.timer;

import com.codecool.timer.controller.TimerController;
import com.codecool.timer.service.TimerService;
import com.codecool.timer.view.View;

public class App {
    public static void main(String[] args) {
        TimerService timerService = new TimerService();
        View view = new View();
        TimerController timerController = new TimerController(timerService, view);
        timerController.run();
    }
}