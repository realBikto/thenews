package thenews.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thenews.database.impl.PostDatabase;
import thenews.model.Post;
import thenews.service.PostService;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDatabase postDatabase;

    @Override
    public boolean saveNewPost(Post post) {
        return postDatabase.save(post);
    }

    @Override
    public Post getPostById(int id) {return postDatabase.findById(id);}

    @Override
    public boolean update(int id, Post object) {return postDatabase.update(id, object);}

    @Override
    public boolean updatePost(Post object) {return postDatabase.updatePost(object);}

    @Override
    public boolean deleteById(int id) {return postDatabase.deleteById(id);}

    @Override
    public List<Post> findAll() {return postDatabase.findAll();}

    @Override
    public List<Post> postsWithoutSection() {return postDatabase.postsWithoutSection();}

    @Override
    public Post getPreviousPostInCategory(int categoryid, int postid) {return postDatabase.getPreviousPostInCategory(categoryid, postid);}

    @Override
    public Post getNextPostInCategory(int categoryid, int postid) {return postDatabase.getNextPostInCategory(categoryid, postid);}
}