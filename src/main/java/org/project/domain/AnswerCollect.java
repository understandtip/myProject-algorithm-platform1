package org.project.domain;

public class AnswerCollect {
    private int id;
    private int aid;
    private int bid;

    public AnswerCollect() {
    }

    public AnswerCollect(int id, int aid, int bid) {
        this.id = id;
        this.aid = aid;
        this.bid = bid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "AnswerCollect{" +
                "id=" + id +
                ", aid=" + aid +
                ", bid=" + bid +
                '}';
    }
}
