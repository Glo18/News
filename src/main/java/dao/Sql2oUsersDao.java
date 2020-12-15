package dao;

import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public abstract class Sql2oUsersDao implements UsersDao {
    private final Sql2o sql2o;

    public Sql2oUsersDao (Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Users users) {
        String sql = "INSERT INTO users (username, userPosition, userRole, departmentId) VALUES (:username, :userposition, :userrole, :departmentId)";
        try (Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .throwOnMappingFailure(false)
                    .bind(users)
                    .addParameter("name", users.getName())
                    .addParameter("position", users.getPosition())
                    .addParameter("role", users.getRole())
                    .addParameter("departmentId", users.getDepartmentId())
                    .executeUpdate()
                    .getKey();
            users.setId(id);
        }
    }

    @Override
    public List<Users> getAllUser() {
        String sql = "SELECT * FROM users";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Users.class);
        }catch (Sql2oException ex) {
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public Users getUserById(int id) {
        String sql = "SELECT * FROM users WHERE id =:id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Users.class);
        } catch (Sql2oException ex) {
            System.out.println(ex);
            return null;
        }
    }

}
