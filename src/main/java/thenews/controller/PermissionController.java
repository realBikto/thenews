package thenews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thenews.database.impl.PermissionDatabase;
import thenews.model.BaseDBModel;
import thenews.model.Permission;

import java.util.List;

@RestController
@RequestMapping("/api/v1/permission")
public class PermissionController {

    @Autowired
    private PermissionDatabase permissionDatabase;

    @PostMapping
    public ResponseEntity<BaseDBModel> save(@RequestBody Permission permission){
        return ResponseEntity.ok(new BaseDBModel(permissionDatabase.save(permission)));
    }

    @PutMapping
    public ResponseEntity<BaseDBModel> update(@PathVariable int id, @RequestBody Permission permission){
        if (permissionDatabase.findById(id) != null){
            return ResponseEntity.ok(new BaseDBModel(permissionDatabase.update(id, permission)));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Permission>> findAll(){
        return ResponseEntity.ok(permissionDatabase.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permission> findById(@PathVariable int id){
        return ResponseEntity.ok(permissionDatabase.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Permission> delete(@PathVariable int id){
        if (permissionDatabase.deleteById(id)){
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
