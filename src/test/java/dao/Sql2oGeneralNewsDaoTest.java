package dao;

import models.GeneralNews;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertNotEquals;

public class Sql2oGeneralNewsDaoTest {
    private Connection conn;
    private Sql2oGeneralNewsDao GeneralNewsDao;
    private Sql2oDepartmentNewsDao DepartmentNewsDao;

    private static  Sql2o sql2o;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/departments_test";
        Sql2o sql2o = new Sql2o(connectionString, "glory", "g@twiri");
        GeneralNewsDao = new Sql2oGeneralNewsDao(sql2o);
//        DepartmentNewsDao = new Sql2oDepartmentNewsDao(sql2o);
        conn = sql2o.open();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addingGeneralNewsSetsId() throws Exception {
        GeneralNews testGeneralNews = setupNewGeneralNews();
        int originalGeneralNewsId = testGeneralNews.getId();
        GeneralNewsDao.add(testGeneralNews);
        assertNotEquals(originalGeneralNewsId ,testGeneralNews.getId());
    }

    public GeneralNews setupNewGeneralNews(){
        return new GeneralNews("Psychology", "Mental wellness", "Juma");
    }
}
