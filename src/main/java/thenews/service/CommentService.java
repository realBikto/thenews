package thenews.service;

import thenews.model.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> findByPostId(int Id);
    boolean save(Comment comment);
}
