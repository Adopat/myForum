package com.justin.myForum.service;

import com.justin.myForum.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> list();
    Category findById(int id);
}
