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
            String sql = String.format("insert into news_core.category (name, createdat)" +
                            " values ('%s','%s');", object.getName(), object.getCreatedat());
            jdbcTemplate.execute(sql);
            return findByName(object.getName());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Category update(int id, Category object) {
        try {
            String sql = String.format("update news_core.category set name = '%s', createdat = '%s'" +
                            " where categotyid = %d;", object.getName(), object.getCreatedat(), id);
            jdbcTemplate.execute(sql);
            return findById(object.getCategoryid());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Category> findAll() {
        return jdbcTemplate.query("select * from news_core.category;", new CategoryMapper());
    }

    @Override
    public Category findById(int id) {
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject("select * from news_core.category where categoryid = ?;", params,new CategoryMapper());
    }

    @Override
    public boolean deleteById(int id) {
        try{
            String sql = String.format("delete from news_core.category where categoryid = %d;", id);
            jdbcTemplate.execute(sql);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Category findByName(String name) {
        Object[] params = new Object[] {name};
        return jdbcTemplate.queryForObject("select * from news_core.category where name = '" + name + "';", new CategoryMapper());
    }
}
