package com.wuzhao.dao.impl;

import com.wuzhao.dao.UserDao;
import com.wuzhao.pojo.User;

/**
 * @auther legionwu
 * @create 2021-04-22 8:45
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql="select id,username,password,email from t_user where username = ?";
        return queryForone(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql="select id,username,password,email from t_user where username = ? and password = ?";
        return queryForone(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql="insert into t_user(username,password,email) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
