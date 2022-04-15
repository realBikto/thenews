package thenews.database.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import thenews.database.PermissionDB;
import thenews.mapper.PermissionMapper;
import thenews.model.Permission;

import java.util.List;

@Repository
public class PermissionDatabase implements PermissionDB {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(Permission object) {
        try {
            String sql = String.format("insert into news_core.permission (name) values ('%s');",
                    object.getName());
            jdbcTemplate.execute(sql);
            return true;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(int id, Permission object) {
        if(id > 0) {
            String sql = String.format("update news_core.permission set name = '%s' where permissionid = %d;",
                    object.getName(), id);
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Permission> findAll() {
        return jdbcTemplate.query("select * from news_core.permission;", new PermissionMapper());
    }

    @Override
    public Permission findById(int id) {
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject("select * from news_core.permission where permissionid = ?;",
                params, new PermissionMapper());
    }

    @Override
    public boolean deleteById(int id){
        try{
            String sql = String.format("delete from news_core.permission where permissionid = %d;", id);
            jdbcTemplate.execute(sql);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Permission> findByUser(String email) {
        return jdbcTemplate.query("select p.* from news_core.permission p" +
                " inner join news_core.role_permission gp on p.permissionid = gp.permissionid" +
                " inner join news_core.user_table u on gp.roleid = u.roleid" +
                " where u.email = '" + email + "';", new PermissionMapper());
    }

}