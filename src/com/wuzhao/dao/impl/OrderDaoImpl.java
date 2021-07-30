package com.wuzhao.dao.impl;

import com.wuzhao.dao.OrderDao;
import com.wuzhao.pojo.Order;

/**
 * Created with IDEA
 * auther:Natuos
 * Date:2021/5/14
 * Time:20:01
 */


public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public int saveOrder(Order order) {
        String sql="insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";

        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
