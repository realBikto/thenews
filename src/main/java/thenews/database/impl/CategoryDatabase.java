package thenews.database.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import thenews.database.CategoryDB;
import thenews.mapper.CategoryMapper;
import thenews.model.Category;

import java.util.List;

@Repository
public class CategoryDatabase implements CategoryDB {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Category save(Category object) {
        try {
            String sql = String.format("insert into public.category (name, createdat)" +
                            " values ('%s','%s');", object.getName(), object.getCreatedat());
            jdbcTemplate.execute(sql);
            return findByName(object.getName());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Category update(int id, Category object) {
        try {
            String sql = String.format("update public.category set name = '%s', createdat = '%s'" +
                            " where categoryid = %d;", object.getName(), object.getCreatedat(), id);
            jdbcTemplate.execute(sql);
            return findById(object.getCategoryid());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Category> findAll() {
        return jdbcTemplate.query("select * from public.category;", new CategoryMapper());
    }

    @Override
    public Category findById(int id) {
        return jdbcTemplate.queryForObject("select * from public.category where categoryid = " + id + ";", new CategoryMapper());
    }

    @Override
    public boolean deleteById(int id) {
        try{
            String sql = String.format("delete from public.category where categoryid = %d;", id);
            jdbcTemplate.execute(sql);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Category findByName(String name) {
        return jdbcTemplate.queryForObject("select * from public.category where name = '" + name + "';", new CategoryMapper());
    }
}
