package dao;

import models.DepartmentNews;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertNotEquals;

public class Sql2oDepartmentNewsDaoTest {
    private Connection conn;
    private Sql2oGeneralNewsDao GeneralNewsDao;
    private Sql2oDepartmentNewsDao DepartmentNewsDao;

    private static  Sql2o sql2o;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/department_test";
        Sql2o sql2o = new Sql2o(connectionString, "glory", "myPassword");
        GeneralNewsDao = new Sql2oGeneralNewsDao(sql2o);
        DepartmentNewsDao = new Sql2oDepartmentNewsDao(sql2o);
        conn = sql2o.open();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addingGeneralNewsSetsId() throws Exception {
        DepartmentNews testDepartmentNews = setupNewDepartmentNews();
        int originalDepartNewsId = testDepartmentNews.getId();
        DepartmentNewsDao.add(testDepartmentNews);

        assertNotEquals(originalDepartNewsId ,testDepartmentNews.getId());
    }

    public DepartmentNews setupNewDepartmentNews(){
        return new DepartmentNews(0,"Budgeting", "Expenditure", "Kyle");
    }
}
