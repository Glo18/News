package dao;

import models.DepartmentNews;

import java.util.List;

public interface DepartmentNewsDao {
    void add(DepartmentNews departmentNews);

    List<DepartmentNews> getAllDepartmentNews();

    DepartmentNews getDepartmentNewsById(int id);

}
