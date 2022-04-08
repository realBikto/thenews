package thenews.database;

import thenews.model.Permission;

import java.util.List;

public interface PermissionDB extends BaseDB<Permission>{

    public List<Permission> findByUser(String email);
}
