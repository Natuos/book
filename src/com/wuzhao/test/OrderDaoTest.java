package com.wuzhao.test;

import com.wuzhao.dao.OrderDao;
import com.wuzhao.dao.impl.OrderDaoImpl;
import com.wuzhao.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created with IDEA
 * auther:Natuos
 * Date:2021/5/14
 * Time:20:08
 */


public class OrderDaoTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao=new OrderDaoImpl();
        orderDao.saveOrder(new Order("1234567890",new Date(),new BigDecimal(100),0,1));

    }
}