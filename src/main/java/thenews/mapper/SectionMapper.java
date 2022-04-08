package thenews.mapper;

import org.springframework.jdbc.core.RowMapper;
import thenews.model.Section;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SectionMapper implements RowMapper<Section> {

    @Override
    public Section mapRow(ResultSet rs, int i) throws SQLException {
        Section section = new Section();
        section.setSectionid(rs.getInt("sectionid"));
        section.setName(rs.getString("name"));
        return section;
    }
}
