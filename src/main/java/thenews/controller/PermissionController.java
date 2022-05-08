package thenews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thenews.database.PermissionDB;
import thenews.model.BaseDBModel;
import thenews.model.Permission;

import java.util.List;

@RestController
@RequestMapping("/api/v1/permission")
public class PermissionController {

    @Autowired
    private PermissionDB permissionDB;

    @PostMapping
    public ResponseEntity<BaseDBModel> save(@RequestBody Permission permission){
        return ResponseEntity.ok(new BaseDBModel(permissionDB.save(permission)));
    }

    @PutMapping
    public ResponseEntity<BaseDBModel> update(@PathVariable int id, @RequestBody Permission permission){
        if (permissionDB.findById(id) != null){
            return ResponseEntity.ok(new BaseDBModel(permissionDB.update(id, permission)));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Permission>> findAll(){
        return ResponseEntity.ok(permissionDB.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Permission> findById(@PathVariable int id){
        return ResponseEntity.ok(permissionDB.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Permission> delete(@PathVariable int id){
        if (permissionDB.deleteById(id)){
            return ResponseEntity.ok(null);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
