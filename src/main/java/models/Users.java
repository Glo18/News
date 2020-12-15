package models;

import java.util.Objects;

public class Users {
    private int id;
    private String Name;
    private String Position;
    private String Role;
    private int departmentId;

    public Users(String Name, String Position, String Role, int departmentId) {
        this.Name = Name;
        this.Position = Position;
        this.Role = Role;
        this.departmentId = departmentId;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String Name() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {

        this.Position = Position;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
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
