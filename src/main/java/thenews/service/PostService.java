package thenews.service;

import thenews.model.Post;

import java.util.List;

public interface PostService {

    public boolean saveNewPost(Post post);
    Post getPostById(int id);
    boolean update(int id, Post object);
    boolean updatePost(Post object);
    boolean deleteById(int id);
    List<Post> findAll();
    List<Post> postsWithoutSection();

}