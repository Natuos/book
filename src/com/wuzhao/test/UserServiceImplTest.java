package com.wuzhao.test;

import com.wuzhao.pojo.User;
import com.wuzhao.service.UserService;
import com.wuzhao.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @auther legionwu
 * @create 2021-04-22 9:43
 */
public class UserServiceImplTest {

    UserService userService=new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null,"bbj168","666666","bbj168@qq.com"));
        userService.registUser(new User(null,"abc168","666666","abc168@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"bbj168","666666","bbj168@qq.com")));
    }

    @Test
    public void existsUsername() {
        if(userService.existsUsername("bbj168")){
            System.out.println("用户名存在");
        }else{
            System.out.println("用户名可用!");
        }
    }
}