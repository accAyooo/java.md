package com.study.mybatis.dao;

import com.study.mybatis.entity.Users;
import com.study.mybatis.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @Author: shixiangyu
 * @Description:
 * @Date: create in 下午10:31 2018/4/2
 */
public class UsersDao {
    private SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
    private List<Users> list;

    public List<Users> findall() {
        try {
            list = sqlSession.selectList("findAll");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return list;
    }
}
