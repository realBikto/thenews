package thenews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thenews.database.CategoryDB;
import thenews.model.BaseDBModel;
import thenews.model.Category;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryDB categoryDB;

    @GetMapping
    public ResponseEntity<List<Category>> findAll () {
        return ResponseEntity.ok(categoryDB.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById (@PathVariable int id) {
        if (categoryDB.findById(id) != null){
            return ResponseEntity.ok(categoryDB.findById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<BaseDBModel> save (@RequestBody Category category) {
        return ResponseEntity.ok(new BaseDBModel(categoryDB.save(category)));
    }

    @PutMapping
    public ResponseEntity<BaseDBModel> update (@PathVariable int id, @RequestBody Category category) {
        if (categoryDB.findById(id) != null){
            return ResponseEntity.ok(new BaseDBModel(categoryDB.update(id, category)));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> delete(@PathVariable int id){
        if (categoryDB.deleteById(id)){
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
