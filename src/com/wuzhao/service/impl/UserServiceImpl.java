package com.wuzhao.service.impl;

import com.wuzhao.dao.UserDao;
import com.wuzhao.dao.impl.UserDaoImpl;
import com.wuzhao.pojo.User;
import com.wuzhao.service.UserService;

/**
 * @auther legionwu
 * @create 2021-04-22 9:35
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao=new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if(userDao.queryUserByUsername(username)==null){
            //等于null说明没查到，没查到表示可用
            return false;
        }
        return true;
    }
}
