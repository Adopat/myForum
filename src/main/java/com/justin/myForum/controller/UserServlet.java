package com.justin.myForum.controller;

import com.justin.myForum.domain.User;
import com.justin.myForum.service.UserService;
import com.justin.myForum.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
@WebServlet(name = "userServlet",urlPatterns = {"/user"})
public class UserServlet extends BaseServlet {
    // control 调用service
    private UserService userService = new UserServiceImpl();

    /**
     * 注册接口 http://localhost:8080/user?method=register
     * @param request
     * @param response
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        // 将用户请求封装成Map
        Map<String,String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        int i = userService.register(user);
        if(i>0){
            //注册成功,跳转到登录界面
            request.setAttribute("msg","注册成功"+user.getUserName());
            request.getRequestDispatcher("/user/login.jsp").forward(request,response);

        }else{
            //注册失败，跳转到注册界面
            request.getRequestDispatcher("/user/register.jsp").forward(request,response);
        }
    }
    /**
     * 用户登录接口 http://localhost:8080/user?method=login
     * @param request
     * @param response
     */
    public void login(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        String phone = request.getParameter("phone");
        String pwd = request.getParameter("pwd");
        User user = userService.login(phone,pwd);
        if(user!=null){
            request.getSession().setAttribute("loginUser",user);
            System.out.println("登录成功!!");
            // 跳转页面
            response.sendRedirect("/topic?method=list&c_id=1");
        }else{
            System.out.println("密码或账号错误!!");
            request.setAttribute("msg","用户名或者密码不正确!!");
            request.getRequestDispatcher("/user/login.jsp").forward(request,response);
        }
    }

    /**
     * 退出登录 注销 http://localhost:8080/user?method=logout
     * @param request
     * @param response
     */
    public void logout(HttpServletRequest request,HttpServletResponse response) throws IOException {

        request.getSession().invalidate();
        // 注销登录
        response.sendRedirect("/topic?method=list&c_id=1");
    }

}
