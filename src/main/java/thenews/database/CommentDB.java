package thenews.database;

import thenews.model.Comment;

import java.util.List;

public interface CommentDB extends BaseDB<Comment>{

    Comment findByComment(String comment);
    List<Comment> findByPostId(int id);
}
