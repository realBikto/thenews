package thenews.service.impl;

import org.springframework.stereotype.Service;
import thenews.model.Role;
import thenews.service.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    public List<Role> getAllRoles() {
        return List.of(
                new Role(
                        1L,
                        "roleName"
                )
        );
    }
}
