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
}
