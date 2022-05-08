package thenews.database.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import thenews.database.RolePermissionDB;
import thenews.mapper.RolePermissionMapper;
import thenews.model.RolePermission;

import java.util.List;

@Repository
public class RolePermissionDatabase implements RolePermissionDB {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(RolePermission object) {
        try {
            String sql = String.format("insert into news_core.role_permission (roleid, permissionid) values (%d, %d);",
                    object.getRoleid(), object.getPermissionid());
            jdbcTemplate.execute(sql);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(int id, RolePermission object) {
        if(object.getRoleid() > 0) {
            String sql = String.format("update news_core.role_permission set permissionid = %d where roleid = %d;",
                    object.getPermissionid(), object.getRoleid());
            jdbcTemplate.execute(sql);
        }return false;
    }

    @Override
    public List<RolePermission> findAll() {
        return jdbcTemplate.query("select * from news_core.role_permission;", new RolePermissionMapper());
    }

    @Override
    public RolePermission findById(int id) {
        return jdbcTemplate.queryForObject("select * from news_core.role_permission where rolepermissionid = " + id + ";",
                 new RolePermissionMapper());
    }

    @Override
    public boolean deleteById(int permissionid){
        try{
            String sql = String.format("delete from news_core.role_permission where permissionid = %d;", permissionid);
            jdbcTemplate.execute(sql);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
