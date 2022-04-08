package thenews.database.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import thenews.database.SectionDB;
import thenews.mapper.SectionMapper;
import thenews.model.Section;

import java.util.List;

@Repository
public class SectionDatabase implements SectionDB {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(Section object) {
        try {
            String sql = String.format("insert into news_core.section (name) values ('%s')", object.getName());
            jdbcTemplate.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(int id, Section object) {
        if (id > 0) {
            String sql = String.format("update news_core.section set name = '%s' where sectionid = %d", object.getName(), id);
            jdbcTemplate.execute(sql);
            return true;
        }
        return false;
    }

    @Override
    public List<Section> findAll() {
        return jdbcTemplate.query("select * from news_core.section", new SectionMapper());
    }

    @Override
    public Section findById(int id) {
        try {
            Object[] params = new Object[]{id};
            return jdbcTemplate.queryForObject("select * from news_core.section where sectionid = ?", params, new SectionMapper());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean deleteById(int id){
        try{
            String sql = String.format("delete from news_core.section where sectionid = %d", id);
            jdbcTemplate.execute(sql);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
