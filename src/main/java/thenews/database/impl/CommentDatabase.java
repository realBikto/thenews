package thenews.database.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import thenews.database.CommentDB;
import thenews.mapper.CommentMapper;
import thenews.model.Comment;

import java.util.List;

@Repository
public class CommentDatabase implements CommentDB {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(Comment object) {
        try {
            String sql = String.format("insert into news_core.comment (postid, comment, username, createdat)" +
                    " values (%d,'%s','%s','%s')", object.getPostid(), object.getCommentid(), object.getUsername(),
                    object.getCreatedat());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Comment object) {
        if (object.getCommentid() > 0) {
            String sql = String.format("update news_core.comment set postid = %d, comment = '%s', username = '%s'," +
                            " createdat = '%s' where commentid = %d", object.getPostid(), object.getCommentid(),
                    object.getUsername(), object.getCreatedat(), object.getCommentid());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Comment> findAll() {
        return jdbcTemplate.query("select * from news_core.comment", new CommentMapper());
    }

    @Override
    public Comment findById(int id) {
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject("select * from news_core.comment where commentid = ?", params, new CommentMapper());
    }
}
