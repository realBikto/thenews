package thenews.model;

import java.time.LocalDate;

public class Category {

    private Integer categoryid;
    private String name;
    private LocalDate createdat;

    public Category(Integer categoryid, String name, LocalDate createdat) {
        this.categoryid = categoryid;
        this.name = name;
        this.createdat = createdat;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedat() {
        return createdat;
    }

    public void setCreatedat(LocalDate createdat) {
        this.createdat = createdat;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryid=" + categoryid +
                ", name='" + name + '\'' +
                ", createdat=" + createdat +
                '}';
    }
}
