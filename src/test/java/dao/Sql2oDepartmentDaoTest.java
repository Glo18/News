package dao;

import models.Department;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertNotEquals;

public class Sql2oDepartmentDaoTest {
    private Connection conn;
    private Sql2oUsersDao UsersDao;
    private Sql2oDepartmentDao DepartmentDao;

    private static Sql2o sql2o;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/department_test";
        Sql2o sql2o = new Sql2o(connectionString, "glory", "myPassword");
        UsersDao = new Sql2oUsersDao(sql2o);
        DepartmentDao = new Sql2oDepartmentDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addingDepartmentSetsId() throws Exception {
        Department testDepartment = setupNewDepartment();
        int originalDepartmentId = testDepartment.getId();
        DepartmentDao.add(testDepartment);
        assertNotEquals(originalDepartmentId,testDepartment.getId());
    }

    //helper
    public Department setupNewDepartment(){
        return new Department ("Finance", "Accounts", 30);
    }
}
