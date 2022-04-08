package thenews.service;

import thenews.model.Post;
import thenews.model.PostSection;
import thenews.model.Section;

import java.util.List;

public interface PostSectionService {
    List<PostSection> findAll();
    boolean updatePostSection(Post post, Section section);
    boolean updatePostSection(PostSection postSection);
}
