package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UsersTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void instantiatesUsersDetails() throws Exception{
        Users testUsers = setUpUsers();
        assertEquals("Steve", testUsers.getName());
        assertEquals("Accountant", testUsers.getPosition());
        assertEquals("Accounting", testUsers.getRole());
        assertEquals(0, testUsers.getDepartmentId());

    }
    @Test
    public void  getUsername() {
        Users testUsers = setUpUsers();
        assertEquals("Steve", testUsers.getName());
    }
    @Test
    public void setId(){
        Users testUsers = setUpUsers();
        testUsers.setId(5);
        assertEquals(5,testUsers.getId());
    }
    public Users setUpUsers() {
        return new Users("Adam", "Accountant", "Accounting", 0);

    }
}