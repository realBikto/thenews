package thenews.role;

import org.springframework.stereotype.Service;

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
