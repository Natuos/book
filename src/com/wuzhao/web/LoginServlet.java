package com.wuzhao.web;

import com.wuzhao.pojo.User;
import com.wuzhao.service.UserService;
import com.wuzhao.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @auther legionwu
 * @create 2021-04-22 21:37
 */
public class LoginServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        //2.调用XxxService.xxx()处理业务
        //userService.login()登录
        User loginUser=userService.login(new User(null,username,password,null));
        //3.根据Login()方法返回结果判断登录是否成功
        if(loginUser == null){
            //把错误信息，和回显的表单项信息，保存到Request域中
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);
            //跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            //登录成功
            //跳到成功页面Login_success.html
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }


}
