package com.example.software_technology;

public class SalaryRecord {
        private int salaryRecID;
        private int employeeID;
        private Double salaryAmount;
        private String submissionDate;

        public SalaryRecord(int salaryRecID, int employeeID, double salaryAmount, String submissionDate) {
            this.salaryRecID = salaryRecID;
            this.employeeID = employeeID;
            this.salaryAmount = salaryAmount;
            this.submissionDate = submissionDate;
        }

        public void setEmployeeID(int employeeID) {
            this.employeeID = employeeID;
        }

        public void setSalaryAmount(double salaryAmount) { this.salaryAmount = salaryAmount; }

        public void setSubmissionDate(String submissionDate) {
            this.submissionDate = submissionDate;
        }

        public int getEmployeeID() { return this.employeeID; }

        public double getSalaryAmount() { return this.salaryAmount; }

        public int getSalaryRecID() { return this.salaryRecID; }

        public String getSubmissionDate() {
            return this.submissionDate;
        }
}
