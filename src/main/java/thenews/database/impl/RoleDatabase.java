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
            String sql = String.format("insert into public.role (name) values ('%s');", object.getName());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(int id, Role object) {
        if (id > 0){
            String sql = String.format("update public.role set name = '%s' where roleid = %d;", object.getName(), id);
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Role> findAll() {
        return jdbcTemplate.query("select * from public.role;", new RoleMapper());
    }

    @Override
    public Role findById(int id) {
        return jdbcTemplate.queryForObject("select * from public.role where roleid = " + id + ";", new RoleMapper());
    }

    @Override
    public boolean deleteById(int id) {
        try{
            String sql = String.format("delete from public.role where roleid = %d;", id);
            jdbcTemplate.execute(sql);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Role findByUser(String email) {
        return jdbcTemplate.queryForObject("select r.* from public.role r inner join public.user_table u on " +
                "r.roleid = u.roleid where u.email = '" + email + "';", new RoleMapper());
    }
}
