package thenews.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thenews.database.impl.PostDatabase;
import thenews.database.impl.PostSectionDatabase;
import thenews.database.impl.SectionDatabase;
import thenews.model.Post;
import thenews.model.PostSection;
import thenews.model.Section;
import thenews.service.PostSectionService;

import java.util.List;

@Service
public class PostSectionServiceImpl implements PostSectionService {
    @Autowired
    private PostSectionDatabase postSectionDatabase;

    @Autowired
    private SectionDatabase sectionDatabase;

    @Autowired
    private PostDatabase postDatabase;

    @Override
    public List<PostSection> findAll() {return postSectionDatabase.findAll();}

    @Override
    public boolean updatePostSection(Post post, Section section) {
        PostSection postSection = new PostSection();
        postSection.setPostid(post.getPostid());
        postSection.setSectionid(section.getSectionid());

        try {
            PostSection postsectionToEvaluate = postSectionDatabase.findByPostId((int) postSection.getPostid());
            Section sectionToEvaluate = sectionDatabase.findById((int) postSection.getSectionid());
            Post postToEvaluate = postDatabase.findById((int) postSection.getPostid());

            if (postsectionToEvaluate != null && sectionToEvaluate != null && postToEvaluate != null) {
                postSectionDatabase.deleteByPostId((int) postSection.getPostid());
                postSectionDatabase.save(postSection);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updatePostSection(PostSection postSection) {
        try {
            PostSection postsectionToEvaluate = postSectionDatabase.findByPostId((int) postSection.getPostid());
            Section sectionToEvaluate = sectionDatabase.findById((int) postSection.getSectionid());
            Post postToEvaluate = postDatabase.findById((int) postSection.getPostid());

            if (postsectionToEvaluate != null && sectionToEvaluate != null && postToEvaluate != null) {
                postSectionDatabase.deleteByPostId((int) postSection.getPostid());
                postSectionDatabase.save(postSection);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
