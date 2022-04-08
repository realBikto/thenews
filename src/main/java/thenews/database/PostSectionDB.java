package thenews.database;

import thenews.model.PostSection;

import java.util.List;

public interface PostSectionDB extends BaseDB<PostSection>{

    public PostSection findByPostId(int Id);
    List<PostSection> findBySectionId(int Id);
    public boolean deleteByPostId(int id);

}
