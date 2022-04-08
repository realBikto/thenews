package thenews.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thenews.database.impl.CommentDatabase;
import thenews.model.BaseDBModel;
import thenews.model.Comment;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/comment")
public class CommentController {

    @Autowired
    private CommentDatabase commentDatabase;

    @GetMapping
    public ResponseEntity<List<Comment>> findAll() {
        return ResponseEntity.ok(commentDatabase.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> findById(@PathVariable int id) {
        if(commentDatabase.findById(id) != null){
            return ResponseEntity.ok(commentDatabase.findById(id));
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PostMapping
    public ResponseEntity<BaseDBModel> save(@RequestBody Comment comment){
        return ResponseEntity.ok(new BaseDBModel(commentDatabase.save(comment)));
    }

    @PutMapping
    public ResponseEntity<BaseDBModel> update(@PathVariable int id, @RequestBody Comment comment){
        if (commentDatabase.findById(id) != null){
            return ResponseEntity.ok(new BaseDBModel(commentDatabase.update(id, comment)));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseDBModel> delete(@PathVariable int id){
        return ResponseEntity.ok(new BaseDBModel(commentDatabase.deleteById(id)));
    }


    @GetMapping("/post/{id}")
    public ResponseEntity<List<Comment>> findByPostId(@PathVariable int id){
        if(commentDatabase.findByPostId(id) != null){
            return ResponseEntity.ok(commentDatabase.findByPostId(id));
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
