package com.wuzhao.test;

import com.wuzhao.pojo.Cart;
import com.wuzhao.pojo.CartItem;
import com.wuzhao.service.OrderService;
import com.wuzhao.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created with IDEA
 * auther:Natuos
 * Date:2021/5/14
 * Time:20:28
 */


public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java从入门到精通",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"数据结构域算法",1,new BigDecimal(100),new BigDecimal(100)));

        OrderService orderService=new OrderServiceImpl();
        System.out.println("订单号是："+orderService.createOrder(cart,1));
    }
}