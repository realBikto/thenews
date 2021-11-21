package thenews.mapper;

import org.springframework.jdbc.core.RowMapper;
import thenews.model.Category;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<Category> {
    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category category = new Category();
        category.setCategoryid(rs.getInt("categoryid"));
        category.setName(rs.getString("name"));
        category.setCreatedat(rs.getDate("createdat"));
        return category;
    }
}
