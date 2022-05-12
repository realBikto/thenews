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
            String sql = String.format("insert into public.post (title, subtitle, content, userid, image, categoryid, createdat)" +
                            " values ('%s','%s','%s',%d,'%s',%d,now());", object.getTitle(), object.getSubtitle(), object.getContent(),
                    object.getUserid(), object.getImage(), object.getCategoryid());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(int id, Post object) {
        if (id > 0) {
            String sql = String.format("update public.post set title = '%s', subtitle = '%s', content = '%s', userid = %d, image = '%s', categoryid = %d where postid = %d;",
                    object.getTitle(), object.getSubtitle(), object.getContent(), object.getUserid(), object.getImage(), object.getCategoryid(), id);
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePost(Post object) {
        if(object.getPostid() > 0) {
            try {
                String sql = String.format("update public.post set title = '%s', subtitle = '%s', content = '%s', userid = %d, image = '%s', categoryid = %d where postid = %d;",
                        object.getTitle(), object.getSubtitle(), object.getContent(), object.getUserid(), object.getImage(), object.getCategoryid(), object.getPostid());
                jdbcTemplate.execute(sql);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @Override
    public List<Post> findAll() {
        return jdbcTemplate.query("select * from public.post order by postid desc;", new PostMapper());
    }

    @Override
    public Post findById(int id) {
        return jdbcTemplate.queryForObject("select * from public.post where postid = " + id + ";", new PostMapper());
    }

    @Override
    public boolean deleteById(int id) {
        try{
            String sql = String.format("delete from public.post where postid = %d;", id);
            jdbcTemplate.execute(sql);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<Post> getLastNews() {
        return jdbcTemplate.query("select * from public.post p order by p.postid desc limit 5;", new PostMapper());
    }

    @Override
    public List<Post> getSports() {
        return jdbcTemplate.query("select * from public.post p inner join public.post_section ps on p.postid = ps.postid " +
                        "inner join public.section s on ps.sectionid = s.sectionid where s.name = 'sports' " +
                        "order by p.postid desc limit 4;",
                new PostMapper());
    }

    @Override
    public List<Post> getReports() {
        return jdbcTemplate.query("select * from public.post p inner join public.post_section ps on p.postid = ps.postid " +
                        "inner join public.section s on ps.sectionid = s.sectionid where s.name = 'reports' " +
                        "order by p.postid desc limit 4;",
                new PostMapper());
    }

    @Override
    public List<Post> getOpinion() {
        return jdbcTemplate.query("select * from public.post p inner join public.post_section ps on p.postid = ps.postid " +
                        "inner join public.section s on ps.sectionid = s.sectionid where s.name = 'opinion' " +
                        "order by p.postid desc limit 4;",
                new PostMapper());
    }

    @Override
    public List<Post> getInternational() {
        return jdbcTemplate.query("select * from public.post p inner join public.post_section ps on p.postid = ps.postid " +
                        "inner join public.section s on ps.sectionid = s.sectionid where s.name = 'international' " +
                        "order by p.postid desc limit 4;",
                new PostMapper());
    }

    @Override
    public List<Post> getNational() {
        return jdbcTemplate.query("select * from public.post p inner join public.post_section ps on p.postid = ps.postid " +
                        "inner join public.section s on ps.sectionid = s.sectionid where s.name = 'national' " +
                        "order by p.postid desc limit 4;",
                new PostMapper());
    }

    @Override
    public List<Post> getCulture() {
        return jdbcTemplate.query("select * from public.post p inner join public.post_section ps on p.postid = ps.postid " +
                        "inner join public.section s on ps.sectionid = s.sectionid where s.name = 'culture' " +
                        "order by p.postid desc limit 4;",
                new PostMapper());
    }

    @Override
    public List<Post> getPostsByCategory(String category) {
        return jdbcTemplate.query("select * from public.post p inner join public.category c on p.categoryid = c.categoryid " +
                        "where c.name = '" + category + "' order by p.postid desc limit 10;",
                new PostMapper());
    }

    @Override
    public Post getPreviousPostInCategory(int categoryid, int postid) {
        return jdbcTemplate.queryForObject("select p.* from (select  *, lag(postid) over (order by postid) as prev" +
                " from public.post where categoryid = '" + categoryid + "') x" +
                " inner join public.post p on p.postid = coalesce(x.prev, x.postid)" +
                " where x.postid = " + postid + ";", new PostMapper());
    }

    @Override
    public Post getNextPostInCategory(int categoryid, int postid) {
        return jdbcTemplate.queryForObject("select p.* from (select  p.*, lead(postid) over (order by postid) as next" +
                " from public.post p where categoryid = '" + categoryid + "') x" +
                " inner join public.post p on p.postid = coalesce(x.next, x.postid)" +
                " where x.postid = " + postid + ";", new PostMapper());
    }

    @Override
    public List<Post> getPostsByUser(int userid) {
        return jdbcTemplate.query("select * from public.post where userid = " + userid + ";", new PostMapper());
    }
}
