package org.project.domain;

import java.util.List;

public class Note {
    private int id;			//id
    private String content;		//内容
    private String nickname;	//昵称
    private String time;		//发布时间
    private String resId;		//回复对象id
    private String replyPost;	//根留言id
    private int isDelete;         //是否点赞
    private int aid;            //所属题解的id
    private String respondent;	//回复对象昵称
    private List<Note> follows; //回复列表，仅根留言有

    public Note() {
    }

    public Note(int id, String content, String nickname, String time, String resId, String replyPost, int isDelete, int aid, String respondent, List<Note> follows) {
        this.id = id;
        this.content = content;
        this.nickname = nickname;
        this.time = time;
        this.resId = resId;
        this.replyPost = replyPost;
        this.isDelete = isDelete;
        this.aid = aid;
        this.respondent = respondent;
        this.follows = follows;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public String getReplyPost() {
        return replyPost;
    }

    public void setReplyPost(String replyPost) {
        this.replyPost = replyPost;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getRespondent() {
        return respondent;
    }

    public void setRespondent(String respondent) {
        this.respondent = respondent;
    }

    public List<Note> getFollows() {
        return follows;
    }

    public void setFollows(List<Note> follows) {
        this.follows = follows;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", nickname='" + nickname + '\'' +
                ", time='" + time + '\'' +
                ", resId='" + resId + '\'' +
                ", replyPost='" + replyPost + '\'' +
                ", isDelete=" + isDelete +
                ", aid=" + aid +
                ", respondent='" + respondent + '\'' +
                ", follows=" + follows +
                '}';
    }
}

