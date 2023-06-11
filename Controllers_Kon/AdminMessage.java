package com.example.software_technology;

public class AdminMessage {

        private int messageID;
        private String senderID;
        private String receiverID;
        private String title;
        private String content;

        public AdminMessage(int messageID, String senderID, String receiverID, String title, String content) {
            this.messageID = messageID;
            this.senderID = senderID;
            this.receiverID = receiverID;
            this.title = title;
            this.content = content;
        }

        public void setSenderID(String senderID) {
            this.senderID = senderID;
        }

        public void setReceiverID(String receiverID) {
            this.receiverID = receiverID;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getSenderID() { return this.senderID; }

        public String getReceiverID() { return this.receiverID; }

        public int getMessageID() { return this.messageID; }

        public String getTitle() {
            return this.title;
        }

        public String getContent() {
            return this.content;
        }
    }


