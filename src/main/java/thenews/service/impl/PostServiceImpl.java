package thenews.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thenews.database.PostDB;
import thenews.model.Post;
import thenews.service.PostService;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDB postDB;

    @Override
    public boolean saveNewPost(Post post) {
        return postDB.save(post);
    }

    @Override
    public Post getPostById(int id) {
        return postDB.findById(id);
    }

    @Override
    public boolean update(int id, Post object) {
        return postDB.update(id, object);
    }

    @Override
    public boolean updatePost(Post object) {
        return postDB.updatePost(object);
    }

    @Override
    public boolean deleteById(int id) {
        return postDB.deleteById(id);
    }

    @Override
    public List<Post> findAll() {
        return postDB.findAll();
    }

    @Override
    public Post getPreviousPostInCategory(int categoryid, int postid) {
        return postDB.getPreviousPostInCategory(categoryid, postid);
    }

    @Override
    public Post getNextPostInCategory(int categoryid, int postid) {
        return postDB.getNextPostInCategory(categoryid, postid);
    }

    @Override
    public List<Post> getPostsByUser(int userid) {
        return postDB.getPostsByUser(userid);
    }
    
    @Override
    public List<Post> getPostsByCategory(String category) {
        return postDB.getPostsByCategory(category);
    }
}