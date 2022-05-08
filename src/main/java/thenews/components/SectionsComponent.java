package thenews.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import thenews.database.PostDB;
import thenews.database.SectionDB;
import thenews.model.Post;
import thenews.model.Section;

import java.util.ArrayList;
import java.util.List;

@Component("sectionsComponent")
public class SectionsComponent {

    @Autowired
    PostDB postDB;

    @Autowired
    SectionDB sectionDB;

    public List<Post> getLastNews() {
        return new ArrayList<>(postDB.getLastNews());
    }

    public List<Post> getSports() {
        return new ArrayList<>(postDB.getSports());
    }

    public List<Post> getReports() {
        return new ArrayList<>(postDB.getReports());
    }

    public List<Post> getOpinion() {
        return new ArrayList<>(postDB.getOpinion());
    }

    public List<Post> getInternational() {
        return new ArrayList<>(postDB.getInternational());
    }

    public List<Post> getNational() {
        return new ArrayList<>(postDB.getNational());
    }

    public List<Post> getCulture() {
        return new ArrayList<>(postDB.getCulture());
    }

    public List<Section> getSections() {
        return new ArrayList<>(sectionDB.findAll());
    }


}
