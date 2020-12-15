package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DepartmentTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void instantiatesDepartmentDetails() throws Exception{
        Department testDepartment = SetUpDepartment();
        assertEquals("production", testDepartment.getDepartmentName());
        assertEquals("valuation", testDepartment.getDepartmentDescription());
        assertEquals(0, testDepartment.getNumberOfEmployees());
    }

    @Test
    public void  getDepartmentDescription() {
        Department testDepartment = SetUpDepartment();
        assertEquals("valuation", testDepartment.getDepartmentDescription());
    }

    @Test
    public void setId(){
        Department testDepartment = SetUpDepartment();
        testDepartment.setId(4);
        assertEquals(4,testDepartment.getId());
    }

    public Department SetUpDepartments() {
        return new Department("production", "valuation", 0);

    }
}