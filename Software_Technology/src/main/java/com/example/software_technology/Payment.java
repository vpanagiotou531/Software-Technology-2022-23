package com.example.software_technology;

public class Payment {

    private int paymentID;
    private int reservationID;
    private double amount;
    private int completion;

    public Payment(int paymentID, int reservationID, double amount, int completion, String content) {
        this.paymentID = paymentID;
        this.reservationID = reservationID;
        this.amount = amount;
        this.completion = completion;
    }

    public void setReservationID(int reservationID) { this.reservationID = reservationID; }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCompletion(int completion) {
        this.completion = completion;
    }

    public int getPaymentID() { return this.paymentID; }

    public int getReservationID() { return this.reservationID; }

    public double getAmount() { return this.amount; }

    public int getCompletion() {
        return this.completion;
    }
}


