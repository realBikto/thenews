package thenews.database;

import thenews.model.Role;

public interface RoleDB extends BaseDB<Role>{

    Role findByUser(String email);
}
