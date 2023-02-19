package com.justin.myForum.service.impl;

import com.justin.myForum.dao.CategoryDao;
import com.justin.myForum.domain.Category;
import com.justin.myForum.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = new CategoryDao();
    @Override
    public List<Category> list() {
        return  categoryDao.list();
    }

    @Override
    public Category findById(int id) {
        return categoryDao.findById(id);
    }
}
