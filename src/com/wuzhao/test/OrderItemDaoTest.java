package com.wuzhao.test;

import com.wuzhao.dao.OrderItemDao;
import com.wuzhao.dao.impl.OrderItemDaoImpl;
import com.wuzhao.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created with IDEA
 * auther:Natuos
 * Date:2021/5/14
 * Time:20:11
 */


public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao=new OrderItemDaoImpl();

        orderItemDao.saveOrderItem(new OrderItem(null,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100),"1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null,"javascript从入门到精通",2,new BigDecimal(100),new BigDecimal(200),"1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null,"Netty从入门到精通",1,new BigDecimal(100),new BigDecimal(100),"1234567890"));
    }
}