package thenews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thenews.database.impl.PostSectionDatabase;
import thenews.model.BaseDBModel;
import thenews.model.PostSection;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post_section")
public class PostSectionController {

    @Autowired
    private PostSectionDatabase postSectionDatabase;

    @PostMapping
    public ResponseEntity<BaseDBModel> save(@RequestBody PostSection postSection){
        return ResponseEntity.ok(new BaseDBModel(postSectionDatabase.save(postSection)));
    }

    @PutMapping
    public ResponseEntity<BaseDBModel> update(@PathVariable int id, @RequestBody PostSection postSection){
        if (postSectionDatabase.findById(id) != null){
            return ResponseEntity.ok(new BaseDBModel(postSectionDatabase.update(id, postSection)));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<BaseDBModel> delete(@PathVariable int id){
        return ResponseEntity.ok(new BaseDBModel(postSectionDatabase.deleteByPostId(id)));
    }

    @GetMapping
    public ResponseEntity<List<PostSection>> findAll(){
        return ResponseEntity.ok(postSectionDatabase.findAll());
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<PostSection> findByPostId(@PathVariable int id){
        return ResponseEntity.ok(postSectionDatabase.findByPostId(id));
    }

    @GetMapping("/section/{id}")
    public ResponseEntity<List<PostSection>> findBySectionId(@PathVariable int id){
        return ResponseEntity.ok(postSectionDatabase.findBySectionId(id));
    }
}
