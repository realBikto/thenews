package thenews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thenews.database.impl.UserDatabase;
import thenews.model.BaseDBModel;
import thenews.model.User;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/user")
public class UserController {

    @Autowired
    public UserDatabase userDatabase;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userDatabase.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable int id) {
        return ResponseEntity.ok(userDatabase.findById(id));
    }

    @PostMapping
    public ResponseEntity<BaseDBModel> save(@RequestBody User user){
        return ResponseEntity.ok(new BaseDBModel(userDatabase.save(user)));
    }

    @PutMapping
    public ResponseEntity<BaseDBModel> update(@RequestBody User user) {
        return ResponseEntity.ok(new BaseDBModel(userDatabase.update(user)));
    }
}
