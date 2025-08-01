package com.loggermiddleware;



public class LogEntry {

    private String message;
    private String level;
    private String stack;
    private String package1;

    public LogEntry(String message, String level, String stack, String package1) {
        this.message = message;
        this.level = level;
        this.stack = stack;
        this.package1 = package1;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public String getPackage1() {
        return package1;
    }

    public void setPackage1(String package1) {
        this.package1 = package1;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

}