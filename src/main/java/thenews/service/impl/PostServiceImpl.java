package thenews.service.impl;

import org.springframework.stereotype.Service;
import thenews.model.Post;
import thenews.service.PostService;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Override
    public List<Post> getAllPosts() {
        return List.of(
                new Post(
                        1L,
                        "PostTitle example 1",
                        "PostContent example 1",
                        2L,
                        "image.url.com",
                        23L,
                        LocalDate.now()
                )
        );
    }
}