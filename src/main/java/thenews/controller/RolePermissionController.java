package thenews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thenews.database.RolePermissionDB;
import thenews.model.BaseDBModel;
import thenews.model.RolePermission;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role_permission")
public class RolePermissionController {

    @Autowired
    private RolePermissionDB rolePermissionDB;

    @PostMapping
    public ResponseEntity<BaseDBModel> save(@RequestBody RolePermission rolePermission){
        return ResponseEntity.ok(new BaseDBModel(rolePermissionDB.save(rolePermission)));
    }

    @GetMapping
    public ResponseEntity<List<RolePermission>> findAll(){
        return ResponseEntity.ok(rolePermissionDB.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolePermission> findById(@PathVariable int id){
        return ResponseEntity.ok(rolePermissionDB.findById(id));
    }

    @DeleteMapping("/permission/{permissionid}")
    public ResponseEntity<BaseDBModel> delete(@PathVariable int rolePermission){
        return ResponseEntity.ok(new BaseDBModel(rolePermissionDB.deleteById(rolePermission)));
    }
}
