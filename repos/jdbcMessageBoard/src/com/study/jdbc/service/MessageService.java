package com.study.jdbc.service;

import com.study.jdbc.bean.Message;
import com.study.jdbc.bean.User;
import com.study.jdbc.dao.MessageDao;

import java.util.List;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午4:09 2018/3/31
 */
public class MessageService {
    private MessageDao messageDao;

    public MessageService() {
        messageDao = new MessageDao();
    }

    public List<Message> getMessages(int page, int pageSize) {
        return messageDao.getMessages(page, pageSize);
    }

    public int totalCount() {
        return messageDao.messageCount();
    }

    public boolean addMessage(User user, String title, String content) {
        int result = messageDao.addMessage(user.getId(), user.getUsername(), title, content);
        if (result > 0) {
            return true;
        }
        return false;
    }
}
