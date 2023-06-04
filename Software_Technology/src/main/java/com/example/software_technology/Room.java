package com.example.software_technology;

public class Room {
    private int roomID;
    private String roomType;
    private int roomCapacity;
    private double pricePerNight;
    private String roomStatus;

    public Room(int roomID, String roomType, int roomCapacity, double pricePerNight, String roomStatus) {
        this.roomID = roomID;
        this.roomType = roomType;
        this.roomCapacity = roomCapacity;
        this.pricePerNight = pricePerNight;
        this.roomStatus = roomStatus;
    }

    public void setRoomType(String roomType) { this.roomType = roomType; }

    public void setRoomStatus(String roomStatus) { this.roomStatus = roomStatus; }

    public void setRoomCapacity(int roomCapacity) { this.roomCapacity = roomCapacity; }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getRoomID() { return this.roomID; }

    public String getRoomType() { return this.roomType; }

    public int getRoomCapacity() { return this.roomCapacity; }

    public double getPricePerNight() {
        return this.pricePerNight;
    }

    public String getRoomStatus() { return this.roomStatus; }

}
