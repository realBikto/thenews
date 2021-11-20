package thenews.mapper;

import org.springframework.jdbc.core.RowMapper;
import thenews.model.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<Role> {
    @Override
    public Role mapRow(ResultSet rs, int rowNum) throws SQLException{
        Role role = new Role();
        role.setRoleid(rs.getInt("roleid"));
        role.setName(rs.getString("name"));
        return role;
    }
}
