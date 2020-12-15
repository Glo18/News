package models;

import java.util.List;
import java.util.Objects;

public class Department {
    private int id;
    private String departmentName;
    private String departmentDescription;
    private int numberOfEmployees;
    private List<Users> departmentUsers;
    private List<DepartmentNews> departmentNews;

    public Department(String departmentName, String departmentDescription, int numberOfEmployees) {
        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
        this.numberOfEmployees = numberOfEmployees;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNoOfEmployees(int numberOfEmployees) {

        this.numberOfEmployees = numberOfEmployees;
    }

    public List<Users> getDepartmentUsers() {

        return departmentUsers;
    }

    public void setDepartmentUsers(List<Users> departmentUsers) {
        this.departmentUsers = departmentUsers;
    }

    public List<DepartmentNews> getDepartmentNews() {
        return departmentNews;
    }

    public void setDepartmentNews(List<DepartmentNews> departmentNews) {
        this.departmentNews = departmentNews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return getId() == that.getId() &&
                getNumberOfEmployees() == that.getNumberOfEmployees() &&
                Objects.equals(getDepartmentName(), that.getDepartmentName()) &&
                Objects.equals(getDepartmentDescription(), that.getDepartmentDescription()) &&
                Objects.equals(getDepartmentUsers(), that.getDepartmentUsers()) &&
                Objects.equals(getDepartmentNews(), that.getDepartmentNews());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDepartmentName(), getDepartmentDescription(), getNumberOfEmployees(), getDepartmentUsers(), getDepartmentNews());
    }
}

