package com.example.software_technology;

public class Feedback {

    private int feedbackID;
    private int customerID;
    private double starsRating;
    private int feedbackStatus;

    public Feedback(int feedbackID, int customerID, double starsRating, int feedbackStatus) {
        this.feedbackID = feedbackID;
        this.customerID = customerID;
        this.starsRating = starsRating;
        this.feedbackStatus = feedbackStatus;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setStarsRating(double starsRating) {
        this.starsRating = starsRating;
    }

    public void setFeedbackStatus(int feedbackStatus) {
        this.feedbackStatus = feedbackStatus;
    }

    public int getCustomerID() { return this.customerID; }

    public int getFeedbackID() { return this.feedbackID; }

    public double getStarsRating() {
        return this.starsRating;
    }

    public int getFeedbackStatus() {
        return this.feedbackStatus;
    }
}


