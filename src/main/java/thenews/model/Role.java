package thenews.model;

public class Role {

    private Long roleid;
    private String name;

    public Role(Long roleid, String name) {
        this.roleid = roleid;
        this.name = name;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleid=" + roleid +
                ", name='" + name + '\'' +
                '}';
    }
}
