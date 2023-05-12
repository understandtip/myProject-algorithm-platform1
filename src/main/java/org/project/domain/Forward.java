package org.project.domain;

public class Forward {
    private int bid;
    private int fid;

    public Forward() {
    }

    public Forward(int bid, int fid) {
        this.bid = bid;
        this.fid = fid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    @Override
    public String toString() {
        return "Forward{" +
                "bid=" + bid +
                ", fid=" + fid +
                '}';
    }
}
