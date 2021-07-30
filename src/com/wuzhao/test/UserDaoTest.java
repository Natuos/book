package com.wuzhao.test;

import com.wuzhao.dao.UserDao;
import com.wuzhao.dao.impl.UserDaoImpl;
import com.wuzhao.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @auther legionwu
 * @create 2021-04-22 9:14
 */
public class UserDaoTest {
    UserDao userDao=new UserDaoImpl();
    @Test
    public void queryUserByUsername() {

        if(userDao.queryUserByUsername("admin")==null){
            System.out.println("用户名可用！");
        }else{
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if(userDao.queryUserByUsernameAndPassword("admin","admin")==null){
            System.out.println("用户名或密码错误，登录失败");
        }else{
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"kzj168","123456","wzj123.com")));
    }
}