package thenews.database;

import thenews.model.Category;

import java.util.List;

public interface CategoryDB {
    Category save(Category object);
    Category update(int id, Category object);
    List<Category> findAll();
    Category findById(int id);
    boolean deleteById(int id);
    Category findByName(String name);
}
