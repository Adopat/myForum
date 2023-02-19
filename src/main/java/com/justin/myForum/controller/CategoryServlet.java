package com.justin.myForum.controller;

import com.justin.myForum.domain.Category;
import com.justin.myForum.service.CategoryService;
import com.justin.myForum.service.impl.CategoryServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * control 调用service service 调用 dao 层
 */
@WebServlet(name = "categoryServlet",urlPatterns = {"/category"})
public class CategoryServlet extends BaseServlet {
    private CategoryService categoryService = new CategoryServiceImpl();
    /**
     * 返回全部分类
     */
    public void list(HttpServletRequest request, HttpServletResponse response){
        List<Category> list = categoryService.list();
        System.out.println(list.toString());
    }
    public void findById(HttpServletRequest request,HttpServletResponse response){
        System.out.println("======调用findById 方法=======");
        String strId = request.getParameter("id");
        int id = Integer.parseInt(strId);
        Category category = categoryService.findById(id);
        System.out.println(category.toString());
    }
}
