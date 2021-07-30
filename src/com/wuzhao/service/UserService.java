package com.wuzhao.service;

import com.wuzhao.pojo.User;

/**
 * @auther legionwu
 * @create 2021-04-22 9:30
 */
public interface UserService {
    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     * @param user
     * @return 如果返回null，说明登录失败，返回有值，是登录成功
     */
    public User login(User user);

    /**
     * 检查用户是否可用
     * @param username
     * @return 返回true表示用户名已经存在返回false表示用户名可用
     */
    public boolean existsUsername(String username);
}
