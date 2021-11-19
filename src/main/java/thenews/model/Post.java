package thenews.model;

import java.time.LocalDate;

public class Post {

    // Attributes
    private Long id;
    private String title;
    private String content;
    private Long userid;
    private String image;
    private Long categoryid;
    private LocalDate createdat;
    private String type = "POST";

    public Post(Long id, String title, String content, Long userid, String image, Long categoryid, LocalDate createdat) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userid = userid;
        this.image = image;
        this.categoryid = categoryid;
        this.createdat = createdat;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public LocalDate getCreatedat() {
        return createdat;
    }

    public void setCreatedat(LocalDate createdat) {
        this.createdat = createdat;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userid=" + userid +
                ", image='" + image + '\'' +
                ", categoryid=" + categoryid +
                ", createdat=" + createdat +
                ", type='" + type + '\'' +
                '}';
    }
}
