package thenews.mapper;

import org.springframework.jdbc.core.RowMapper;
import thenews.model.Post;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostMapper implements RowMapper<Post> {
    @Override
    public Post mapRow(ResultSet rs, int rowNum) throws SQLException{
        Post post = new Post();
        post.setPostid(rs.getInt("postid"));
        post.setTitle(rs.getString("title"));
        post.setSubtitle(rs.getString("subtitle"));
        post.setContent(rs.getString("content"));
        post.setUserid(rs.getInt("userid"));
        post.setImage(rs.getString("image"));
        post.setCategoryid(rs.getInt("categoryid"));
        post.setCreatedat(rs.getDate("createdat"));
        return post;
    }

}
