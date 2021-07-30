package com.wuzhao.service.impl;

import com.wuzhao.dao.BookDao;
import com.wuzhao.dao.OrderDao;
import com.wuzhao.dao.OrderItemDao;
import com.wuzhao.dao.impl.BookDaoImpl;
import com.wuzhao.dao.impl.OrderDaoImpl;
import com.wuzhao.dao.impl.OrderItemDaoImpl;
import com.wuzhao.pojo.*;
import com.wuzhao.service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * Created with IDEA
 * auther:Natuos
 * Date:2021/5/14
 * Time:20:15
 */


public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao=new OrderDaoImpl();
    private OrderItemDao orderItemDao=new OrderItemDaoImpl();
    BookDao bookDao=new BookDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        //订单号===唯一性
        String orderId=System.currentTimeMillis()+""+userId;
        //创建一个订单对象
        Order order=new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        //保存订单
        orderDao.saveOrder(order);

        //遍历购物车中每一个商品项转换成为订单项保存到数据库
        for(Map.Entry<Integer, CartItem>entry: cart.getItems().entrySet()){
            //获取每一个购物车中的商品项
            CartItem cartItem= entry.getValue();
            //转换为每一个订单项
            OrderItem orderItem=new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            //保存订单到数据库
            orderItemDao.saveOrderItem(orderItem);

            //更新库存和销量
            Book book=bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);
        }
        //清空购物车
        cart.clear();
        return orderId;
    }
}
