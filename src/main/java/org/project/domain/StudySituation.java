package org.project.domain;

public class StudySituation {
    private int count;
    private int id;
    private String username;

    public StudySituation() {
    }

    public StudySituation(int count, int id, String username) {
        this.count = count;
        this.id = id;
        this.username = username;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "StudySituation{" +
                "count=" + count +
                ", id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
