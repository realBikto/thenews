package thenews.database.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import thenews.database.PostDB;
import thenews.mapper.PostMapper;
import thenews.model.Post;

import java.util.List;

@Repository
public class PostDatabase implements PostDB {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(Post object){
        try {
            String sql = String.format("insert into post (title, content, userid, image, categoryid, createdat, type)" +
                            " values ('%s','%s',%d,'%s',%d,'%s','%s')", object.getTitle(), object.getContent(),
                    object.getUserid(), object.getImage(), object.getCategoryid(), object.getCreatedat(), object.getType());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Post object) {
        if (object.getPostid() > 0) {
            String sql = String.format("update post set title = '%s', content = '%s', userid = %d, image = '%s', categoryid = %d, type = '%s' where postid = %d", object.getTitle(), object.getContent(), object.getUserid(), object.getImage(), object.getImage(), object.getCategoryid(), object.getType(), object.getPostid());
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Post> findAll() {
        return jdbcTemplate.query("select * from news_core.post", new PostMapper());
    }

    @Override
    public Post findById(int id) {
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject("select * from news_core.post where postid = ?", params, new PostMapper());
    }
}
