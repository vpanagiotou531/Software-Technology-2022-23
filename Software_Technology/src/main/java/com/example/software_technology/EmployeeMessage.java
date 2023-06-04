package com.example.software_technology;

public class EmployeeMessage {

    private int messageID;
    private int senderID;
    private int receiverID;
    private String title;
    private String content;

    public EmployeeMessage(int messageID, int senderID, int receiverID, String title, String content) {
        this.messageID = messageID;
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.title = title;
        this.content = content;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public void setReceiverID(int receiverID) {
        this.receiverID = receiverID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSenderID() { return this.senderID; }

    public int getReceiverID() { return this.receiverID; }

    public int getMessageID() { return this.messageID; }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }
}


