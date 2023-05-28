public class Reservation {
    private int reservationID;
    private String checkInDate;
    private String checkOutDate;
    private int customerID;
    private int roomID;
    private double price;
    private int adultNumber;
    private int childrenNumber;
    private int includedMeal;
    private int includedPool;
    private int includedTennisCourt;

    public Reservation(int reservationID, String checkInDate, String checkOutDate, int customerID, int roomID, double price, int adultNumber, int childrenNumber, int includedMeal, int includedPool, int includedTennisCourt) {
        this.reservationID = reservationID;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.customerID = customerID;
        this.roomID = roomID;
        this.price = price;
        this.adultNumber = adultNumber;
        this.childrenNumber = childrenNumber;
        this.includedMeal = includedMeal;
        this.includedPool = includedPool;
        this.includedTennisCourt = includedTennisCourt;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkInDate = checkOutDate;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public void setPrice(double price) { this.price = price; }

    public void setAdultNumber(int adultNumber) { this.adultNumber = adultNumber; }

    public void setChildrenNumber(int childrenNumber) { this.childrenNumber = childrenNumber; }

    public void setIncludedMeal(int includedMeal) { this.includedMeal = includedMeal; }

    public void setIncludedPool(int includedPool) { this.includedPool = includedPool; }

    public void setIncludedTennisCourt(int includedTennisCourt) { this.includedTennisCourt = includedTennisCourt; }

    public String getCheckInDate() { return this.checkInDate; }

    public String getCheckOutDate() { return this.checkOutDate; }

    public int getCustomerID() { return this.customerID; }

    public int getRoomID() { return this.roomID; }

    public int getReservationID() { return this.reservationID; }

    public int getChildrenNumber() { return this.childrenNumber; }

    public int getAdultNumber() { return this.adultNumber; }

    public int getIncludedTennisCourt() { return this.includedTennisCourt; }

    public int getIncludedPool() { return this.includedPool; }

    public int getIncludedMeal() { return this.includedMeal; }

    public double getPrice() { return this.price; }


}

