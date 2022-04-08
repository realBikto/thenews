package thenews.mapper;

import org.springframework.jdbc.core.RowMapper;
import thenews.model.PostSection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostSectionMapper implements RowMapper<PostSection> {
    @Override
    public PostSection mapRow(ResultSet rs, int rowNum) throws SQLException {
        PostSection postSection = new PostSection();
        postSection.setPostid(rs.getInt("postid"));
        postSection.setSectionid(rs.getInt("sectionid"));
        return postSection;
    }
}
