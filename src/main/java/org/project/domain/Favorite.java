package org.project.domain;

import java.io.Serializable;

/**
 * 收藏实体类
 */
public class Favorite implements Serializable {
    private Blog blog;//旅游线路对象
    private String indexs;
    private User user;//所属用户

    public Favorite() {
    }

    public Favorite(Blog blog, String indexs, User user) {
        this.blog = blog;
        this.indexs = indexs;
        this.user = user;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getIndexs() {
        return indexs;
    }

    public void setIndexs(String indexs) {
        this.indexs = indexs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "blog=" + blog +
                ", indexs='" + indexs + '\'' +
                ", user=" + user +
                '}';
    }
}
