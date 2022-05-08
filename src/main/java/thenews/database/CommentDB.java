package thenews.database;

import thenews.model.Comment;

import java.util.List;

public interface CommentDB extends BaseDB<Comment>{

    List<Comment> findByPostId(int id);
}
