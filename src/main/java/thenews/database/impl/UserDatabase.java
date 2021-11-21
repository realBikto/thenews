package thenews.database.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import thenews.database.UserDB;
import thenews.mapper.UserMapper;
import thenews.model.User;

import java.util.List;

@Repository
public class UserDatabase implements UserDB {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(User object) {
        try {
            String sql = String.format("insert into news_core.user_table (firstname, lastname, username, password, email, roleid)" +
                            " values ('%s','%s','%s','%s','%s',%d)", object.getFirstname(), object.getLastname(),
                    object.getUsername(), object.getPassword(), object.getEmail(), object.getRoleid());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(User object) {
        if (object.getUserid() > 0) {
            String sql = String.format("update user_table set firstname = '%s', lastname = '%s', username = '%s', password = '%s', email = '%s', roleid = %d where userid = %d", object.getFirstname(), object.getLastname(), object.getUsername(), object.getPassword(), object.getEmail(), object.getRoleid(), object.getUserid());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from news_core.user_table", new UserMapper());
    }

    @Override
    public User findById(int id) {
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject("select * from news_core.user_table where userid = ?", params, new UserMapper());
    }
}
