package thenews.model;

import java.time.LocalDate;

public class Comment {

    // Attributes
    private Long commentid;
    private Long postid;
    private String comment;
    private String username;
    private LocalDate createdat;

    //Constructor
    public Comment(Long commentid, Long postid, String comment, String username, LocalDate createdat) {
        this.commentid = commentid;
        this.postid = postid;
        this.comment = comment;
        this.username = username;
        this.createdat = createdat;
    }

    // Getters and Setters
    public Long getCommentid() {
        return commentid;
    }

    public void setCommentid(Long commentid) {
        this.commentid = commentid;
    }

    public Long getPostid() {
        return postid;
    }

    public void setPostid(Long postid) {
        this.postid = postid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getCreatedat() {
        return createdat;
    }

    public void setCreatedat(LocalDate createdat) {
        this.createdat = createdat;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentid=" + commentid +
                ", postid=" + postid +
                ", comment='" + comment + '\'' +
                ", username='" + username + '\'' +
                ", createdat=" + createdat +
                '}';
    }
}
