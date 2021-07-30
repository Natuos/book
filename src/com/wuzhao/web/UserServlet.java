package com.wuzhao.web;

import com.google.gson.Gson;
import com.wuzhao.pojo.User;
import com.wuzhao.service.UserService;
import com.wuzhao.service.impl.UserServiceImpl;
import com.wuzhao.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();


    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数username
        String username = req.getParameter("username");
        //2.调用userService.existsUsername();
        boolean existsUsername = userService.existsUsername(username);
        //3.把返回的结果封装成为map对象
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("existsUsername",existsUsername);
        Gson gson=new Gson();
        String json = gson.toJson(resultMap);
        resp.getWriter().write(json);
    }
    /**
     * 处理注册的功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2.调用XxxService.xxx()处理业务
        //userService.login()登录
        User loginUser = userService.login(new User(null, username, password, null));
        //3.根据Login()方法返回结果判断登录是否成功
        if (loginUser == null) {
            //把错误信息，和回显的表单项信息，保存到Request域中
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", username);
            //跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            //登录成功
            //保存用户登录的信息到Session域中
            req.getSession().setAttribute("user",loginUser);

            //跳到成功页面Login_success.html
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }

    /**
     * 注销
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.销毁Session中用户登录的信息（或者销毁Session）
        req.getSession().invalidate();
//        2.重定向到首页（或登录页面）
        resp.sendRedirect(req.getContextPath());
    }

    /**
     * 处理登录的功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Session中的验证码
        String token= (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除Session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        //2.检查验证码是否正确 ===写死，要求验证码为;abcde
        if (token!=null && token.equalsIgnoreCase(code)) {
            //正确
            //3.检查用户是否可用
            if (userService.existsUsername(username)) {
                System.out.println("用户名[" + username + "]已存在！");
                //把回显信息，保存到Request域中
                req.setAttribute("msg", "用户名已存在！！");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                //跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                //可用
                //      调用Service保存到数据库
                userService.registUser(new User(null, username, password, email));
                //跳到注册成功页面 regist_success.jsp
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            //把回显信息，保存到Request域中
            req.setAttribute("msg", "验证码错误！！");
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
/*    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {
        String action = req.getParameter("action");
        if ("login".equals(action)) {
            login(req, resp);
        } else if ("regist".equals(action)) {
            regist(req, resp);
        }
    }*/
}

