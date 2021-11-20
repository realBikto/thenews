package thenews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import thenews.database.impl.RoleDatabase;
import thenews.model.Role;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/role")
public class RoleController {

    @Autowired
    private RoleDatabase roleDatabase;

    @GetMapping
    public ResponseEntity<List<Role>> findAll() {
        return ResponseEntity.ok(roleDatabase.findAll());
    }
}
