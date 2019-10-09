package com.codecool.timer.view;

import com.codecool.timer.model.Timer;

import java.util.List;
import java.util.Scanner;

public class View {

    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    private String getUserInput() {
        return scanner.nextLine();
    }

    public void printText(String message) {
        System.out.println(message);
    }

    public String getCommand(String[] command) {
        if (command.length < 1) {
            throw new IllegalArgumentException("No command provided.");
        }
        return command[0];
    }

    public String[] getUserIntention() {
        String command = getUserInput().toLowerCase();
        return command.split(" ");
    }

    public String getTimerName(String[] command) {
        if (command.length < 2) {
            throw new IllegalArgumentException("No timer name given");
        }
        return command[1];
    }

    public void showTimers(List<Timer> timers) {
        timers.forEach(System.out::println);
    }
}