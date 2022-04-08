package thenews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thenews.database.impl.PostDatabase;
import thenews.model.BaseDBModel;
import thenews.model.Post;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/post")
public class PostController {

    @Autowired
    private PostDatabase postDatabase;

    @GetMapping
    public ResponseEntity<List<Post>> findAll(){
        return ResponseEntity.ok(postDatabase.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable int id){
        return ResponseEntity.ok(postDatabase.findById(id));
    }

    @PostMapping
    public ResponseEntity<BaseDBModel> save(@RequestBody Post post){
        return ResponseEntity.ok(new BaseDBModel(postDatabase.save(post)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseDBModel> update(@PathVariable int id, @RequestBody Post post){
        if (postDatabase.findById(id) != null){
            return ResponseEntity.ok(new BaseDBModel(postDatabase.update(id, post)));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseDBModel> delete(@PathVariable int id){
        return ResponseEntity.ok(new BaseDBModel(postDatabase.deleteById(id)));
    }
}
