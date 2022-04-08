package thenews.mapper;

import org.springframework.jdbc.core.RowMapper;
import thenews.model.Permission;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PermissionMapper implements RowMapper<Permission> {
    @Override
    public Permission mapRow(ResultSet rs, int rowNum) throws SQLException {
        Permission permission = new Permission();
        permission.setPermissionid(rs.getInt("permissionid"));
        permission.setName(rs.getString("name"));
        return permission;
    }
}
