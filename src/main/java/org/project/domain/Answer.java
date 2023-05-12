package org.project.domain;

public class Answer {
    private int aid;
    private String title;
    private String content;
    private String username;
    private int bid;

    public Answer() {
    }

    public Answer(int aid, String title, String content, String username, int bid) {
        this.aid = aid;
        this.title = title;
        this.content = content;
        this.username = username;
        this.bid = bid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "aid=" + aid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", username='" + username + '\'' +
                ", bid=" + bid +
                '}';
    }
}
