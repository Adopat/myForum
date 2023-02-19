package com.justin.myForum.controller;

import com.justin.myForum.domain.Reply;
import com.justin.myForum.domain.Topic;
import com.justin.myForum.domain.User;
import com.justin.myForum.dto.PageDTO;
import com.justin.myForum.service.CategoryService;
import com.justin.myForum.service.TopicService;
import com.justin.myForum.service.impl.CategoryServiceImpl;
import com.justin.myForum.service.impl.TopicServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="topicServlet",urlPatterns = {"/topic"})
public class TopicServlet extends BaseServlet {
        // 调用Service 层方法
        private TopicService topicService = new TopicServiceImpl();
        // 调用Service 层方法
        private CategoryService categoryService = new CategoryServiceImpl();
        //默认分页大小
        private static final int pagesize =2;

    /**
     * http://localhost:8080/topic?method=list&c_id=2&page=2
     * topic 分页接口
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
        public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // 获取分类ID
            int cId = Integer.parseInt(request.getParameter("c_id"));
            // 默认第一页
            int page = 1;
            String currentPage = request.getParameter("page");
            if(currentPage!=null&& currentPage!=""){
                page = Integer.parseInt(currentPage);
            }
            PageDTO<Topic> pageDTO = topicService.listTopicPageCid(cId,page,pagesize);
            System.out.println(pageDTO.toString());
            // 增加主题分类
            request.getSession().setAttribute("categoryList",categoryService.list());
            request.setAttribute("topicPage",pageDTO);
            // 请求转发
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }

    /**
     * 查看主题的全部回复
     * @param request http://localhost:8080//topic?method=findDetailById&topic_id=2
     * @param response
     */
        public void findDetailById(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
            //获取topicid
            int topicId = Integer.parseInt(request.getParameter("topic_id"));
            // 默认第一页
            int page = 1;
            String currentPage = request.getParameter("page");
            if(currentPage!=null&& currentPage!=""){
                page = Integer.parseInt(currentPage);
            }
            // 处理浏览量,同一个session 内只算一次
            String sessionReadKey = "is_read_"+topicId;
            // 每一个session 设置一个阅读标识
            Boolean isRead = (Boolean) request.getSession().getAttribute(sessionReadKey);
            if (isRead == null){
                request.getSession().setAttribute(sessionReadKey,true);
                // 新增一个PV
                topicService.addOnePV(topicId);
            }




            Topic topic = topicService.findById(topicId);
            PageDTO<Reply> pageDTO = topicService.findReplyPageByTopicId(topicId,page,pagesize);
            System.out.println("topic信息: "+topic.toString());
            System.out.println(pageDTO.toString());
            request.setAttribute("topic",topic);
            request.setAttribute("replyPage",pageDTO);
            // 请求转发
            request.getRequestDispatcher("/topic_detail.jsp").forward(request,response);


        }

    /**
     * 发布主题 http://localhost:8080/topic?method=addTopic
     * @param request
     * @param response
     */
        public void addTopic(HttpServletRequest request,HttpServletResponse response) throws IOException {
            // 获取登录的用户信息
            User loginUser = (User)request.getSession().getAttribute("loginUser");
            if (loginUser == null){
                request.setAttribute("msg","请登录");
                response.sendRedirect("/user/login.jsp");
                return;
                // 页面跳转
            }
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            int cId = Integer.parseInt(request.getParameter("c_id"));
            int rows = topicService.addTopic(loginUser,title,content,cId);
            if (rows == 1){
                // 发布主题成功
                response.sendRedirect("/topic?method=list&c_id="+cId);
            }else{
                // 发部主题失败
            }

        }

    /**
     * http://localhost:8080/topic?method=replyByTopicId&topic_id=9
     * 盖楼回复
     * @param request
     * @param response
     */
        public void replyByTopicId(HttpServletRequest request,HttpServletResponse response) throws IOException {
            // 获取登录的用户
            User loginUser = (User)request.getSession().getAttribute("loginUser");
            if (loginUser == null){
                request.setAttribute("msg","请登录");
                response.sendRedirect("/user/login.jsp");
                return;
                // 页面跳转
            }
            int topicId = Integer.parseInt(request.getParameter("topic_id"));
            String content = request.getParameter("content");
            int rows = topicService.replyByTopicId(loginUser,topicId,content);
            if(rows==1){
                // 回复成功
                response.sendRedirect("/topic?method=findDetailById&topic_id="+topicId+"&page=1");

            }else{
                // 回复失败
            }
        }



}



