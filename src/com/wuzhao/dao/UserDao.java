package com.wuzhao.dao;


import com.wuzhao.pojo.User;

/**
 * @auther legionwu
 * @create 2021-04-22 8:37
 */
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username 如果返回null，说明没有这个用户。反之亦然
     * @return
     */
    public User queryUserByUsername(String username);

    /**
     * 根据 用户名和密码查询用户信息
     * @param username
     * @param password
     * @return  如果返回null，说明用户名或密码错误，反之亦然
     */
    public User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 保存用户信息
     * @param user
     * @return 返回-1表示操作失败，其他显示sql影响行数
     */
    public int saveUser(User user);
}
