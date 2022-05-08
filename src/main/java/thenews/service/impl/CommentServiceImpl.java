package thenews.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thenews.database.CommentDB;
import thenews.service.CommentService;
import thenews.model.Comment;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDB commentDB;

    @Override
    public List<Comment> getAllComments() {
        return commentDB.findAll();
    }

    @Override
    public List<Comment> findByPostId(int Id) {return commentDB.findByPostId(Id);}

    @Override
    public boolean save(Comment comment) {return commentDB.save(comment);}
}
