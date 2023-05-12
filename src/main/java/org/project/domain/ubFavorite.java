package org.project.domain;

public class ubFavorite {
    private int bid;
    private int indexs;
    private int id;

    public ubFavorite() {
    }

    public ubFavorite(int bid, int indexs, int id) {
        this.bid = bid;
        this.indexs = indexs;
        this.id = id;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getIndexs() {
        return indexs;
    }

    public void setIndexs(int indexs) {
        this.indexs = indexs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ubFavorite{" +
                "bid=" + bid +
                ", indexs=" + indexs +
                ", id=" + id +
                '}';
    }
}
