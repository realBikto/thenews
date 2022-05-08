package thenews.service;

import thenews.model.Post;

import java.util.List;

public interface PostService {

    boolean saveNewPost(Post post);
    Post getPostById(int id);
    boolean update(int id, Post object);
    boolean updatePost(Post object);
    boolean deleteById(int id);
    List<Post> findAll();
    Post getPreviousPostInCategory(int categoryid, int postid);
    Post getNextPostInCategory(int categoryid, int postid);
    List<Post> getPostsByUser(int userid);
    List<Post> getPostsByCategory(String category);
}