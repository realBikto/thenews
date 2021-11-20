package thenews.database.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import thenews.database.RoleDB;
import thenews.mapper.RoleMapper;
import thenews.model.Role;

import java.util.List;

@Repository
public class RoleDatabase implements RoleDB {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(Role object) {
        try {
            String sql = String.format("insert into role (name) values ('%s')", object.getName());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Role object) {
        if (object.getRoleid() > 0){
            String sql = String.format("update role set name = '%s' where roleid = '%d'", object.getName(), object.getRoleid());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Role> findAll() {
        return jdbcTemplate.query("select * from news_core.role", new RoleMapper());
    }

    @Override
    public Role findById(int id) {
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject("select * from news_core.role where roleid = ?", params, new RoleMapper());
    }
}
