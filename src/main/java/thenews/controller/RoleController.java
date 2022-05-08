package thenews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thenews.database.RoleDB;
import thenews.model.BaseDBModel;
import thenews.model.Role;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/role")
public class RoleController {

    @Autowired
    private RoleDB roleDB;

    @GetMapping
    public ResponseEntity<List<Role>> findAll() {
        return ResponseEntity.ok(roleDB.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> findById(@PathVariable int id){
        return ResponseEntity.ok(roleDB.findById(id));
    }

    @PostMapping
    public ResponseEntity<BaseDBModel> save(@RequestBody Role role){
        return ResponseEntity.ok(new BaseDBModel(roleDB.save(role)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseDBModel> update(@PathVariable int id, @RequestBody Role role){
        if (roleDB.findById(id) != null) {
            return ResponseEntity.ok(new BaseDBModel(roleDB.update(id, role)));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Role> delete(@PathVariable int id){
        if (roleDB.deleteById(id)){
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
