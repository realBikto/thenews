package thenews.database;

import thenews.model.PostSection;

import java.util.List;

public interface PostSectionDB extends BaseDB<PostSection>{

    PostSection findByPostId(int Id);
    List<PostSection> findBySectionId(int Id);
    boolean deleteByPostId(int id);

}
