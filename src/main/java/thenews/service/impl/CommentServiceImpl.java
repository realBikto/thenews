package thenews.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thenews.database.impl.CommentDatabase;
import thenews.service.CommentService;
import thenews.model.Comment;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDatabase commentDatabase;

    @Override
    public List<Comment> getAllComments() {
        return commentDatabase.findAll();
    }

    @Override
    public List<Comment> findByPostId(int Id) {return commentDatabase.findByPostId(Id);}

    @Override
    public boolean save(Comment comment) {return commentDatabase.save(comment);}
}
