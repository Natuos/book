package com.wuzhao.web;

import com.wuzhao.pojo.Cart;
import com.wuzhao.pojo.User;
import com.wuzhao.service.OrderService;
import com.wuzhao.service.impl.OrderServiceImpl;
import com.wuzhao.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IDEA
 * auther:Natuos
 * Date:2021/5/14
 * Time:20:34
 */


public class OrderServlet extends BaseServlet{
OrderService orderService=new OrderServiceImpl();
    /**
     * 生成订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //先获取Cart购物车对象
        Cart cart= (Cart) req.getSession().getAttribute("cart");
        //获取UserId
        User loginUser= (User) req.getSession().getAttribute("user");
        if(loginUser==null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        Integer userId=loginUser.getId();
        //调用orderService.createOrder(Cart,UserId)；生成订单
        String orderId = orderService.createOrder(cart,userId);
        // req.setAttribute("order",orderId);
        //请求转发到/pages/cart/checkout.jsp
        //req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);
        req.getSession().setAttribute("orderId",orderId);

        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");

    }
}
