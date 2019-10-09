package com.codecool.timer.view;

import java.util.List;
import java.util.Scanner;

import com.codecool.timer.model.Timer;

public class TerminalView {

    private Scanner scanner;

    public TerminalView() {
        scanner = new Scanner(System.in);
    }

    public String getUserInput() {
        return scanner.nextLine().toLowerCase();
    }

    public void printText(String message) {
        System.out.println(message);
    }

    public void showTimers(List<Timer> timers) {
        timers.forEach(System.out::println);
    }
}