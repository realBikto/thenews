package thenews.service.impl;

import org.springframework.stereotype.Service;
import thenews.service.CategoryService;
import thenews.model.Category;

import java.time.LocalDate;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public List<Category> getAllCategories() {
        return List.of(
                new Category(
                        1L,
                        "CategoryOne",
                        LocalDate.now()
                )
        );
    }
}
