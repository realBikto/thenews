package thenews.database;

import thenews.model.Post;

import java.util.List;

public interface PostDB extends BaseDB<Post>{

    public List<Post> postsWithoutSection();
    public List<Post> getLastNews();
    public List<Post> getMainTopic();
    public List<Post> getSubTopic();
    public List<Post> getMostPopular();
    public List<Post> getReports();
    public List<Post> getOpinion();
    public List<Post> getPostsByCategory(String category);
    public boolean updatePost(Post object);
}
