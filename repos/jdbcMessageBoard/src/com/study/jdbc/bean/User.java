package com.study.jdbc.bean;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午9:44 2018/3/31
 */
public class User {
    private long id;
    private String username;
    private String password;
    private String realName;
    private String attr;
    private String phoneNum;

    public User(){}

    public User(long id, String username, String password, String realName, String attr, String phoneNum) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.attr = attr;
        this.phoneNum = phoneNum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
