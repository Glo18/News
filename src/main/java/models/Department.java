package models;

import java.util.List;

public class Department {
    private int id;
    private String departmentName;
    private String departmentDescription;
    private int numberOfEmployees;
    private List<Users> departmentUsers;
    private List<DepartmentNews> departmentNews;
}
