package thenews.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thenews.database.CommentDB;
import thenews.model.Comment;
import thenews.service.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDB commentDB;

    @Override
    public List<Comment> findByPostId(int id) {
        return commentDB.findByPostId(id);
    }

    @Override
    public boolean save(Comment comment) {
        return commentDB.save(comment);
    }
}
