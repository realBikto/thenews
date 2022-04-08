package thenews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thenews.database.impl.RolePermissionDatabase;
import thenews.model.BaseDBModel;
import thenews.model.RolePermission;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role_permission")
public class RolePermissionController {

    @Autowired
    private RolePermissionDatabase rolePermissionDatabase;

    @PostMapping
    public ResponseEntity<BaseDBModel> save(@RequestBody RolePermission rolePermission){
        return ResponseEntity.ok(new BaseDBModel(rolePermissionDatabase.save(rolePermission)));
    }

    @GetMapping
    public ResponseEntity<List<RolePermission>> findAll(){
        return ResponseEntity.ok(rolePermissionDatabase.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolePermission> findById(@PathVariable int id){
        return ResponseEntity.ok(rolePermissionDatabase.findById(id));
    }

    @DeleteMapping("/permission/{permissionid}")
    public ResponseEntity<BaseDBModel> delete(@PathVariable int rolePermission){
        return ResponseEntity.ok(new BaseDBModel(rolePermissionDatabase.deleteById(rolePermission)));
    }
}
