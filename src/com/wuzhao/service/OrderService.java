package com.wuzhao.service;

import com.wuzhao.pojo.Cart;

/**
 * Created with IDEA
 * auther:Natuos
 * Date:2021/5/14
 * Time:20:14
 */


public interface OrderService {
    public String createOrder(Cart cart,Integer userId);
}
