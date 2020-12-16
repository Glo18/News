package models;

import java.util.Objects;

public class Users {
    private int id;
    private String name;
    private String position;
    private String role;
    private int departmentId;

    public Users(String Name, String Position, String Role, int departmentId) {
        this.name = Name;
        this.position = Position;
        this.role = Role;
        this.departmentId = departmentId;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String Position) {

        this.position = position;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String Role) {
        this.role = role;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return getId() == users.getId() &&
                Objects.equals(getName(), users.getName()) &&
                Objects.equals(getPosition(), users.getPosition()) &&
                Objects.equals(getRole(), users.getRole()) &&
                Objects.equals(getDepartmentId(), users.getDepartmentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPosition(), getRole(), getDepartmentId());
    }
}
