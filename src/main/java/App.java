import com.google.gson.Gson;
import dao.Sql2oDepartmentDao;
import dao.Sql2oDepartmentNewsDao;
import dao.Sql2oGeneralNewsDao;
import dao.Sql2oUsersDao;
import models.Department;
import models.DepartmentNews;
import models.GeneralNews;
import models.Users;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import exceptions.ApiException;

import static spark.Spark.*;

import java.util.*;

public class App {
    public static void main (String[] args) {
        Sql2oDepartmentDao DepartmentDao;
        Sql2oDepartmentNewsDao DepartmentNewsDao;
        Sql2oGeneralNewsDao GeneralNewsDao;
        Sql2oUsersDao UsersDao;
        Connection conn;
        Gson gson = new Gson();

//        String connectionString = "jdbc:h2:~/NewsAPI.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        String connectionString =  ("jdbc:postgresql://localhost:5432/departments");

        Sql2o sql2o = new Sql2o(connectionString, "glory", "g@twiri");

        DepartmentDao = new Sql2oDepartmentDao(sql2o);
        DepartmentNewsDao = new Sql2oDepartmentNewsDao(sql2o);
        GeneralNewsDao = new Sql2oGeneralNewsDao(sql2o);
        UsersDao = new Sql2oUsersDao(sql2o);
        conn = sql2o.open();

        get("/", "application/json", (req, res) ->
                "{\"message\":\"Welcome to the news portal.\"}");

        post("/departments/new", "application/json", (req, res) -> {
            Department department = gson.fromJson(req.body(), Department.class);
            DepartmentDao.add(department);
            res.status(201);
            return gson.toJson(department);
        });

        post("/departmentNews/new", "application/json", (req, res) -> {
            DepartmentNews departmentNews = gson.fromJson(req.body(), DepartmentNews.class);
            DepartmentNewsDao.add(departmentNews);
            res.status(201);
            return gson.toJson(departmentNews);

        });

        post("/generalNews/new", "application/json", (req, res) -> {
            GeneralNews generalNews = gson.fromJson(req.body(), GeneralNews.class);
            GeneralNewsDao.add(generalNews);
            res.status(201);
            return gson.toJson(generalNews);
        });


        post("/users/new", "application/json", (req, res) -> {
            Users users = gson.fromJson(req.body(), Users.class);
            UsersDao.add(users);
            res.status(201);
            res.type("application/json");
            return gson.toJson(users);
        });

//        Read
        get("/users", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(UsersDao.getAllUser());
        });

        get("/department", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(DepartmentDao.getAllDepartments());
        });

        get("/departmentNews", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(DepartmentNewsDao.getAllDepartmentNews());
        });

        get("/generalNews", "application/json", (req, res) -> {
            res.type("application/json");
            return gson.toJson(GeneralNewsDao.getAllGeneralNews());
        });


//        find


        get("/users/:id", "application/json", (req, res) -> {
            int usersId = Integer.parseInt(req.params("id"));
            Users usersToFind = UsersDao.getUserById(usersId);

            if(usersToFind == null) {
                throw new ApiException(404, String.format("No user with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(usersToFind);
        });

        get("/department/:id", "application/json", (req, res) -> {
            int departmentId = Integer.parseInt(req.params("id"));
            Department departmentToFind = DepartmentDao.getDepartmentById(departmentId );
            if (departmentToFind == null){
                throw new ApiException(404, String.format("No department with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(departmentToFind );
        });

//        get("/departmentNews/:departmentId", "application/json", (req, res) -> {
//            int departmentNewsId = Integer.parseInt(req.params("id"));
//            DepartmentNews departmentNewsToFind = DepartmentNewsDao.getDepartmentNewsById(departmentNewsId );
//            if (departmentNewsToFind== null){
//                throw new ApiException(404, String.format("No department news with the id: \"%s\" exists", req.params("id")));
//            }
//            return gson.toJson(departmentsNewsToFind );
//        });

        get("/departmentNews/:id", "application/json", (req, res) -> {
            int departmentNewsId = Integer.parseInt(req.params("id"));
            DepartmentNews departmentNewsToFind = DepartmentNewsDao.getDepartmentNewsById(departmentNewsId );
            if (departmentNewsToFind== null){
                throw new ApiException(404, String.format("No department news with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(departmentNewsToFind );
        });

        get("/generalNews/:id", "application/json", (req, res) -> { //accept a request in format JSON from an app
            int generalNewsId = Integer.parseInt(req.params("id"));
            GeneralNews generalNewsToFind = GeneralNewsDao.getGeneralNewsById(generalNewsId );
            if (generalNewsToFind== null){
                throw new ApiException(404, String.format("No general news with the id: \"%s\" exists", req.params("id")));
            }
            return gson.toJson(generalNewsToFind );
        });

        exception(ApiException.class, (exception, req, res) -> {
            ApiException err = (ApiException) exception;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json");
            res.status(err.getStatusCode());
            res.body(gson.toJson(jsonMap));
        });

        after((req, res) -> {
            res.type("application/json");
        });
    }
}
