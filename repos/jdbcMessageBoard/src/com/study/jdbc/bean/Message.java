package com.study.jdbc.bean;


import java.util.Date;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午4:21 2018/3/31
 */
public class Message {
    private long id;
    private long userId;
    private String username;
    private String title;
    private String content;
    private Date createTime;

    public Message() {};

    public Message(long id, long userId, String userName, String title, String content, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.username = userName;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
