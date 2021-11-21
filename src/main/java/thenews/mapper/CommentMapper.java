package thenews.mapper;

import org.springframework.jdbc.core.RowMapper;
import thenews.model.Comment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentMapper implements RowMapper<Comment> {
    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException{
        Comment comment = new Comment();
        comment.setCommentid(rs.getInt("commentid"));
        comment.setPostid(rs.getInt("postid"));
        comment.setComment(rs.getString("comment"));
        comment.setUsername(rs.getString("username"));
        comment.setCreatedat(rs.getDate("createdat"));
        return comment;
    }
}
