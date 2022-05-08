package thenews.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thenews.database.CategoryDB;
import thenews.service.CategoryService;
import thenews.model.Category;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDB categoryDB;

    @Override
    public List<Category> getAllCategories() {
        return categoryDB.findAll();
    }
}
