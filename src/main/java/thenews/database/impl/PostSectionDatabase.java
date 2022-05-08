package thenews.database.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import thenews.database.PostSectionDB;
import thenews.mapper.PostSectionMapper;
import thenews.model.PostSection;

import java.util.List;

@Repository
public class PostSectionDatabase implements PostSectionDB {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(PostSection object) {
        try {
            String sql = String.format("insert into news_core.post_section (postid, sectionid) values (%d, %d)", object.getPostid(), object.getSectionid());
            jdbcTemplate.execute(sql);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(int id, PostSection object) {
        if(id > 0) {
            String sql = String.format("update news_core.post_section set sectionid = %d where postid = %d",
                    object.getSectionid(), id);
            jdbcTemplate.execute(sql);
        }
        return false;
    }

    @Override
    public List<PostSection> findAll() {
        return jdbcTemplate.query("select * from news_core.post_section;", new PostSectionMapper());
    }

    @Override
    public PostSection findById(int id) {
        Object[] params = new Object[] {id};
        return jdbcTemplate.queryForObject("select * from news_core.post_section where postsectionid = ?",
                params, new PostSectionMapper());
    }

    @Override
    public boolean deleteById(int id) {
        try{
            String sql = String.format("delete from news_core.post_section where postsectionid = %d;", id);
            jdbcTemplate.execute(sql);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public PostSection findByPostId(int Id) {
        try {
            Object[] params = new Object[] {Id};
            return jdbcTemplate.queryForObject("select * from news_core.post_section where postid = ?",
                    params, new PostSectionMapper());
        } catch (Exception e) {
            return new PostSection();
        }

    }

    @Override
    public List<PostSection> findBySectionId(int Id) {
        try {
            Object[] params = new Object[] {Id};
            return jdbcTemplate.query("select * from news_core.post_section where sectionid = ?",
                    params, new PostSectionMapper());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean deleteByPostId(int id) {
        try{
            String sql = String.format("delete from news_core.post_section where postid = %d", id);
            jdbcTemplate.execute(sql);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
