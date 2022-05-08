package thenews.database;

import thenews.model.Post;

import java.util.List;

public interface PostDB extends BaseDB<Post>{

    List<Post> postsWithoutSection();
    List<Post> getLastNews();
    List<Post> getSports();
    List<Post> getReports();
    List<Post> getOpinion();
    List<Post> getInternational();
    List<Post> getNational();
    List<Post> getCulture();
    List<Post> getPostsByCategory(String category);
    boolean updatePost(Post object);
    Post getPreviousPostInCategory(int categoryid, int postid);
    Post getNextPostInCategory(int categoryid, int postid);
    List<Post> getPostsByUser(int userid);
}
