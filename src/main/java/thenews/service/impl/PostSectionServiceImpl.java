package thenews.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thenews.database.PostDB;
import thenews.database.PostSectionDB;
import thenews.database.SectionDB;
import thenews.model.Post;
import thenews.model.PostSection;
import thenews.model.Section;
import thenews.service.PostSectionService;

import java.util.List;

@Service
public class PostSectionServiceImpl implements PostSectionService {
    @Autowired
    private PostSectionDB postSectionDB;

    @Autowired
    private SectionDB sectionDB;

    @Autowired
    private PostDB postDB;

    @Override
    public List<PostSection> findAll() {
        return postSectionDB.findAll();
    }

    @Override
    public PostSection findByPostId(int postid) {
        return postSectionDB.findByPostId(postid);
    }

    @Override
    public boolean updatePostSection(Post post, Section section) {
        PostSection postSection = new PostSection();
        postSection.setPostid(post.getPostid());
        postSection.setSectionid(section.getSectionid());

        try {
            PostSection postsectionToEvaluate = postSectionDB.findByPostId(postSection.getPostid());
            Section sectionToEvaluate = sectionDB.findById(postSection.getSectionid());
            Post postToEvaluate = postDB.findById(postSection.getPostid());

            if (postsectionToEvaluate != null && sectionToEvaluate != null && postToEvaluate != null) {
                postSectionDB.deleteByPostId(postSection.getPostid());
                postSectionDB.save(postSection);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
