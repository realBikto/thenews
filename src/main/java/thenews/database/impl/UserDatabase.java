package thenews.database.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import thenews.database.UserDB;
import thenews.mapper.UserMapper;
import thenews.model.User;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDatabase implements UserDB {

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User save(User object) {
        try {
            String sql = String.format("insert into news_core.user_table (firstname, lastname, username, password, email, roleid)" +
                            " values ('%s','%s','%s','%s','%s',%d);", object.getFirstname(), object.getLastname(),
                    object.getEmail(), bCryptPasswordEncoder.encode(object.getPassword()), object.getEmail(), object.getRoleid());
            jdbcTemplate.execute(sql);
            return findByEmail(object.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User update(int id, User object) {
        try {
            String sql = String.format("update news_core.user_table set firstname = '%s', lastname = '%s', username = '%s', " +
                            "password = '%s', email = '%s', roleid = %d where userid = %d;", object.getFirstname(),
                    object.getLastname(), object.getEmail(), bCryptPasswordEncoder.encode(object.getPassword()),
                    object.getEmail(), object.getRoleid(), id);
            jdbcTemplate.execute(sql);
            return findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("select * from news_core.user_table;", new UserMapper());
    }

    @Override
    public User findById(int id) {
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject("select * from news_core.user_table where userid = ?;", params, new UserMapper());
    }

    @Override
    public boolean deleteById(int id) {
        try{
            String sql = String.format("delete from news_core.user_table where userid = %d;", id);
            jdbcTemplate.execute(sql);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User findByEmail(String email) {
        Object[] params = new Object[] {email};
        return jdbcTemplate.queryForObject("select * from news_core.user_table where email = ?;",
                params, new UserMapper());
    }
}
