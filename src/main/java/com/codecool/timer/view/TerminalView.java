package com.codecool.timer.view;

import com.codecool.timer.model.Timer;

import java.util.List;
import java.util.Scanner;

public class TerminalView {

    private Scanner scanner;

    public TerminalView() {
        scanner = new Scanner(System.in);
    }

    private String getUserInput() {
        return scanner.nextLine();
    }

    public void printText(String message) {
        System.out.println(message);
    }

    public void showTimers(List<Timer> timers) {
        timers.forEach(System.out::println);
    }

    public String[] getUserIntention() {
        String command = getUserInput().toLowerCase();
        return command.split(" ");
    }

    public String getExtractedCommandFrom(String[] intention) {
        return getParsedIntention(intention, 0, "No command provided.");
    }

    public String getExtractedTimerNameFrom(String[] intention) {
        return getParsedIntention(intention, 1, "No timer name given.");
    }

    private String getParsedIntention(String[] intention, int index, String exceptionMessage) {
        if (intention.length < index + 1) {
            throw new IllegalArgumentException(exceptionMessage);
        }
        return intention[index];
    }
}