package dao;

import models.Users;

import java.util.List;

public interface UsersDao {
    // create
    void add(Users users);

    // Read
    List<Users> getAllUsers();
    Users getUserById(int id);
}
