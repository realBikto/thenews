package thenews.service.impl;


import org.springframework.stereotype.Service;
import thenews.service.CommentService;
import thenews.model.Comment;

import java.time.LocalDate;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Override
    public List<Comment> getAllComments() {
        return List.of(
                new Comment(
                        1L,
                        1L,
                        "This is a comment.",
                        "email@test.com",
                        LocalDate.now()
                )
        );
    }
}
