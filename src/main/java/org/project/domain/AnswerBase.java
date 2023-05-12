package org.project.domain;

public class AnswerBase {
    private int bid;
    private int id;

    public AnswerBase() {
    }

    public AnswerBase(int bid, int id) {
        this.bid = bid;
        this.id = id;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AnswerBase{" +
                "bid=" + bid +
                ", id=" + id +
                '}';
    }
}
