package com.system.farecard.pojo;

public class JourneyFlow {
    private String cardNumber;
    private String channel;
    private double balance;
    private double journeyAmount;
    private double afterJourneyBalance;
    private TouchPoint entryPoint;
    private TouchPoint exitPoint;

    public JourneyFlow(){}

    public JourneyFlow(String cardNumber, String channel, double balance, double journeyAmount, double afterJourneyBalance, TouchPoint entryPoint, TouchPoint exitPoint) {
        this.cardNumber = cardNumber;
        this.channel = channel;
        this.balance = balance;
        this.journeyAmount = journeyAmount;
        this.afterJourneyBalance = afterJourneyBalance;
        this.entryPoint = entryPoint;
        this.exitPoint = exitPoint;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getJourneyAmount() {
        return journeyAmount;
    }

    public void setJourneyAmount(double journeyAmount) {
        this.journeyAmount = journeyAmount;
    }

    public double getAfterJourneyBalance() {
        return afterJourneyBalance;
    }

    public void setAfterJourneyBalance(double afterJourneyBalance) {
        this.afterJourneyBalance = afterJourneyBalance;
    }

    public TouchPoint getEntryPoint() {
        return entryPoint;
    }

    public void setEntryPoint(TouchPoint entryPoint) {
        this.entryPoint = entryPoint;
    }

    public TouchPoint getExitPoint() {
        return exitPoint;
    }

    public void setExitPoint(TouchPoint exitPoint) {
        this.exitPoint = exitPoint;
    }
}
