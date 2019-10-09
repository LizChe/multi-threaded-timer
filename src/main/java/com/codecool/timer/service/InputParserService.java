package com.codecool.timer.service;

public class InputParserService {

    public String[] getUserIntention(String command) {
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
