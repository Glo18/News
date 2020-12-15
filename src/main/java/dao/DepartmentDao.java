package dao;

import models.Department;
import models.DepartmentNews;
import models.Users;

import java.util.List;

public interface DepartmentDao {

    //Create
    void add(Department department);

    //Read
    List<Department> getAllDepartments();
    List<DepartmentNews>getDepartmentNewsById(int id);
    List<Users> getDepartmentUserById (int id);
    Department getDepartmentById(int id);
}
