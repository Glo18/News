package dao;

import models.Department;
import models.DepartmentNews;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentDao implements DepartmentDao {
    private final Sql2o sql2o;

    public Sql2oDepartmentDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(Department department) {
        String sql ="INSERT INTO departments (departmentname, departmentdescription, noofemployees) VALUES (:departmentname, :departmentdescription, :noofemployees )";
        try (Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(department)
                    .addParameter("departmentName", department.getDepartmentName())
                    .addParameter("departmentDescription",department.getDepartmentDescription())
                    .addParameter("numberOfEmployees", department.getNumberOfEmployees())
                    .executeUpdate()
                    .getKey();
            department.setId(id);
        }
    }

    @Override
    public List<Department> getAllDepartments() {
        String sql = "SELECT * FROM department";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql, true)
                    .executeAndFetch(Department.class);
        }catch (Sql2oException ex) {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public List<DepartmentNews> getDepartmentNewsById(int id) {
        String sql = "SELECT * FROM news WHERE departmentId= :id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetch(DepartmentNews.class);
        } catch (Sql2oException ex) {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public List<Users> getDepartmentUserById(int id) {
        String sql = "SELECT * FROM users WHERE departmentId= :id";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetch(Users.class);
        }catch (Sql2oException ex) {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public Department getDepartmentById(int id) {
        String sql = "SELECT * FROM department WHERE id = :id";
        try (Connection con = sql2o.open()){
            return  con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Department.class);
        }catch (Sql2oException ex) {
            System.out.println(ex);
            return null;
        }
    }
}
