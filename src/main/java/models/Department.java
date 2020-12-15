package models;

import java.util.List;

public class Department {
    private int id;
    private String departmentName;
    private String departmentDescription;
    private int numberOfEmployees;
    private List<Users> departmentUsers;
    private List<DepartmentNews> departmentNews;

    public Department(String departmentName, String departmentDescription, int noOfEmployees) {
        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
        this.numberOfEmployees = noOfEmployees;
    }
}
