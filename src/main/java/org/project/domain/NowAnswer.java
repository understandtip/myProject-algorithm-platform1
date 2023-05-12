package org.project.domain;

public class NowAnswer {
    private int aid;
    private int fid;

    public NowAnswer() {
    }

    public NowAnswer(int aid, int fid) {
        this.aid = aid;
        this.fid = fid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    @Override
    public String toString() {
        return "NowAnswer{" +
                "aid=" + aid +
                ", fid=" + fid +
                '}';
    }
}
