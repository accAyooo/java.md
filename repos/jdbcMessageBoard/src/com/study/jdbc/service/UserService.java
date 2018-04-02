package com.study.jdbc.service;

import com.study.jdbc.bean.User;
import com.study.jdbc.dao.UserDao;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午9:46 2018/3/31
 */
public class UserService {
    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public User login(String username, String password) {
        return userDao.login(username, password);
    }
}
