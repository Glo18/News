package dao;

import models.DepartmentNews;

import java.util.List;

public interface DepartmentNewsDao {
    //    Create
    void add(DepartmentNews departmentNews);

    //    Read
    List<DepartmentNews> getAllDepartmentNews();

    DepartmentNews getDepartmentNewsById(int id);

}
