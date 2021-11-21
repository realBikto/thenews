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
    public boolean save(Category object) {
        try {
            String sql = String.format("insert into news_core.category (name, createdat)" +
                            " values ('%s','%s')", object.getName(), object.getCreatedat());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Category object) {
        if (object.getCategoryid() > 0) {
            String sql = String.format("update news_core.category set name = '%s', createdat = '%s'" +
                            " where categotyid = %d", object.getName(), object.getCreatedat());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Category> findAll() {
        return jdbcTemplate.query("select * from news_core.category", new CategoryMapper());
    }

    @Override
    public Category findById(int id) {
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject("select * from news_core.category where categoryid = ?", params,new CategoryMapper());
    }
}
