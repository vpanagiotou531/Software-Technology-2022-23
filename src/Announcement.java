public class Announcement {

    private int announcementID;
    private String title;
    private String content;

    public Announcement(int messageID, String title, String content) {
        this.announcementID = messageID;
        this.title = title;
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAnnouncementID() { return this.announcementID; }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }
}


