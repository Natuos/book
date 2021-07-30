package com.wuzhao.dao.impl;

import com.wuzhao.dao.OrderItemDao;
import com.wuzhao.pojo.OrderItem;

/**
 * Created with IDEA
 * auther:Natuos
 * Date:2021/5/14
 * Time:20:04
 */


public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql="insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }
}
