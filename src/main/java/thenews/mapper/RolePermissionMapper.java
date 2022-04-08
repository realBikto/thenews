package thenews.mapper;

import org.springframework.jdbc.core.RowMapper;
import thenews.model.RolePermission;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RolePermissionMapper implements RowMapper<RolePermission> {
    @Override
    public RolePermission mapRow(ResultSet rs, int rowNum) throws SQLException {
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleid(rs.getInt("roleid"));
        rolePermission.setPermissionid(rs.getInt("permissionid"));
        return rolePermission;
    }
}
