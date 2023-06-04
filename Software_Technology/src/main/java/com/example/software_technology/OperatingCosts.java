package com.example.software_technology;

public class OperatingCosts {

    private int costID;
    private String costType;
    private double costPrice;
    private String salarySubmissionDate;

    public OperatingCosts(int costID, String costType, double costPrice, String salarySubmissionDate) {
        this.costID = costID;
        this.costType = costType;
        this.costPrice = costPrice;
        this.salarySubmissionDate = salarySubmissionDate;
    }

    public void setCostType(String costType) { this.costType = costType; }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public void setSalarySubmissionDate(String salarySubmissionDate) { this.salarySubmissionDate = salarySubmissionDate; }

    public String getCostType() { return this.costType; }

    public double getCostPrice() { return this.costPrice; }

    public String getSalarySubmissionDate() { return this.salarySubmissionDate; }

    public int getCostID() {
        return this.costID;
    }
}



