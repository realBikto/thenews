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
                            " values ('%s','%s',%d,'%s',%d,'%s','%s');", object.getTitle(), object.getContent(),
                    object.getUserid(), object.getImage(), object.getCategoryid(), object.getCreatedat(), object.getType());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(int id, Post object) {
        if (id > 0) {
            String sql = String.format("update post set title = '%s', content = '%s', userid = %d, image = '%s', categoryid = %d, type = '%s' where postid = %d;",
                    object.getTitle(), object.getContent(), object.getUserid(), object.getImage(), object.getImage(), object.getCategoryid(), object.getType(), id);
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Post> findAll() {
        return jdbcTemplate.query("select * from news_core.post;", new PostMapper());
    }

    @Override
    public Post findById(int id) {
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject("select * from news_core.post where postid = ?;", params, new PostMapper());
    }

    @Override
    public boolean deleteById(int id) {
        try{
            String sql = String.format("delete from news_core.post where postid = %d;", id);
            jdbcTemplate.execute(sql);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Post> postsWithoutSection() {
        return jdbcTemplate.query("select p.* from news_core.post_section ps right join news_core.post p on ps.postid = p.postid where ps.sectionid is null;", new PostMapper());
    }

    @Override
    public List<Post> getLastNews() {
        return jdbcTemplate.query("select * from news_core.post p inner join news_core.post_section ps on p.postid = ps.postid " +
                "inner join news_core.section s on ps.sectionid = s.sectionid where s.name = 'news' " +
                "order by p.postid desc limit 5;", new PostMapper());
    }

    @Override
    public Post getMainTopic() {
        return jdbcTemplate.queryForObject("select * from news_core.post p inner join news_core.post_section ps on p.postid = ps.postid " +
                "inner join news_core.section s on ps.sectionid = s.sectionid where s.name = 'maincover' " +
                "order by p.postid desc;", new PostMapper());
    }

    @Override
    public List<Post> getSubTopic() {
        return jdbcTemplate.query("select * from news_core.post p inner join news_core.post_section ps on p.postid = ps.postid " +
                "inner join news_core.section s on ps.sectionid = s.sectionid where s.name = 'subtopic'" +
                "order by p.postid desc;", new PostMapper());
    }

    @Override
    public List<Post> getMostPopular() {
        return jdbcTemplate.query("select * from news_core.post p inner join news_core.post_section ps on p.postid = ps.postid " +
                        "inner join news_core.section s on ps.sectionid = s.sectionid where s.name = 'mostpopular' " +
                        "order by p.postid desc limit 5;",
                new PostMapper());
    }

    @Override
    public List<Post> getReports() {
        return jdbcTemplate.query("select * from news_core.post p inner join news_core.post_section ps on p.postid = ps.postid " +
                        "inner join news_core.section s on ps.sectionid = s.sectionid where s.name = 'reports' " +
                        "order by p.postid desc;",
                new PostMapper());
    }

    @Override
    public List<Post> getOpinion() {
        return jdbcTemplate.query("select * from news_core.post p inner join news_core.post_section ps on p.postid = ps.postid " +
                        "inner join news_core.section s on ps.sectionid = s.sectionid where s.name = 'opinion' " +
                        "order by p.postid desc;",
                new PostMapper());
    }

    @Override
    public List<Post> getPostsByCategory(String category) {
        return jdbcTemplate.query("select * from news_core.post p inner join news_core.category c on p.categoryid = c.categoryid " +
                        "where c.name = '" + category + "' order by p.postid desc limit 5;",
                new PostMapper());
    }
}
