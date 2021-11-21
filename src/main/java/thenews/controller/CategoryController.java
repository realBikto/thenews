package thenews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thenews.database.impl.CategoryDatabase;
import thenews.model.BaseDBModel;
import thenews.model.Category;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryDatabase categoryDatabase;

    @GetMapping
    public ResponseEntity<List<Category>> findAll () {
        return ResponseEntity.ok(categoryDatabase.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById (@PathVariable int id) {
        return ResponseEntity.ok(categoryDatabase.findById(id));
    }

    @PostMapping
    public ResponseEntity<BaseDBModel> save (@RequestBody Category category) {
        return ResponseEntity.ok(new BaseDBModel(categoryDatabase.save(category)));
    }

    @PutMapping
    public ResponseEntity<BaseDBModel> update (@RequestBody Category category) {
        return ResponseEntity.ok(new BaseDBModel(categoryDatabase.update(category)));
    }
}
