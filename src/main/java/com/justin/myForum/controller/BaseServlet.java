package com.justin.myForum.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {
    // 重写Service 方法

    /**
     * 子类的Servlet 被访问，会调用Service 方法，子类没有重写Service方法，会调用父类的Service方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // 获取请求方法
        String method = req.getParameter("method");
        if(method!=null){
                try{
                    // 获取当前被访问对象的字节码对象，和字节码对象里面指定的方法
                    Method targetMethod = this.getClass().getMethod(method,HttpServletRequest.class,HttpServletResponse.class);
                    // 调用对应的方法
                    targetMethod.invoke(this,req,resp);

                }catch (Exception e){
                    e.printStackTrace();
                }
        }

    }
}
