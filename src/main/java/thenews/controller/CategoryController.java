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
        if (categoryDatabase.findById(id) != null){
            return ResponseEntity.ok(categoryDatabase.findById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<BaseDBModel> save (@RequestBody Category category) {
        return ResponseEntity.ok(new BaseDBModel(categoryDatabase.save(category)));
    }

    @PutMapping
    public ResponseEntity<BaseDBModel> update (@PathVariable int id, @RequestBody Category category) {
        if (categoryDatabase.findById(id) != null){
            return ResponseEntity.ok(new BaseDBModel(categoryDatabase.update(id, category)));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathVariable int id){
        if (categoryDatabase.deleteById(id)){
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
