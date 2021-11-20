package thenews.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thenews.database.impl.PostDatabase;
import thenews.model.Post;
import thenews.service.PostService;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDatabase postDatabase;

    @Override
    public boolean saveNewPost(Post post) {
        return postDatabase.save(post);
    }
}