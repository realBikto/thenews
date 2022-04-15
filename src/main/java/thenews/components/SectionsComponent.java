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
        ArrayList<Post> postLastNews = new ArrayList<>();
        for(Post post : postDB.getLastNews()) {
            postLastNews.add(post);
        }
        return postLastNews;
    }

    public List<Post> getMainTopic() {
        List<Post> postMainTopic = postDB.getMainTopic();
        return postMainTopic;
    }

    public List<Post> getSubTopic() {
        ArrayList<Post> postSubTopic = new ArrayList<>();
        for(Post post : postDB.getSubTopic()) {
            postSubTopic.add(post);
        }
        return postSubTopic;
    }

    public List<Post> getMostPopular() {
        ArrayList<Post> postMostPopular = new ArrayList<>();
        for(Post post : postDB.getMostPopular()) {
            postMostPopular.add(post);
        }
        return postMostPopular;
    }

    public List<Post> getReports() {
        ArrayList<Post> postReports = new ArrayList<>();
        for(Post post : postDB.getReports()) {
            postReports.add(post);
        }
        return postReports;
    }

    public List<Post> getOpinion() {
        ArrayList<Post> postOpinion = new ArrayList<>();
        for(Post post : postDB.getOpinion()) {
            postOpinion.add(post);
        }
        return postOpinion;
    }

    public List<Section> getSections() {
        ArrayList<Section> sectionList = new ArrayList<>();
        for(Section section : sectionDB.findAll()) {
            sectionList.add(section);
        }
        return sectionList;
    }


}
