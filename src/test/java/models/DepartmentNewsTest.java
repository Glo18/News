package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentNewsTest  {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    public void instantiatesDepartmentNewsDetails() throws Exception{
        DepartmentNews testDepartmentNews = setUpDepartmentNews();
        assertEquals(12, testDepartmentNews.getDepartmentId());
        assertEquals("Leave Days", testDepartmentNews.getTitle());
        assertEquals("Leave Management", testDepartmentNews.getNews());
        assertEquals("Glory", testDepartmentNews.getAuthor());
    }

    @Test
    public void setId(){
        DepartmentNews testDepartmentNews = setUpDepartmentNews();
        testDepartmentNews.setId(4);
        assertEquals(4,testDepartmentNews.getId());
    }

    public DepartmentNews setUpDepartmentNews(){
        return new DepartmentNews (12, "Leave Days", "Leave Management", "Glory");
    }
}