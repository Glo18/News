package dao;

import models.DepartmentNews;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oDepartmentNewsDao implements DepartmentNewsDao{
    private Sql2o sql2o;

    public Sql2oDepartmentNewsDao (Sql2o sql2o){
        this.sql2o = sql2o;
    }


    @Override
    public void add(DepartmentNews departmentNews) {
        String sql = "INSERT INTO news (departmentId, title, news, author) VALUES (:departmentId, :title, :news, :author)";
        try (Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .throwOnMappingFailure(false)
//                    .bind(departmentNews)
                    .addParameter("departmentId", departmentNews.getDepartmentId())
                    .addParameter("title", departmentNews.getTitle())
                    .addParameter("news", departmentNews.getNews())
                    .addParameter("author", departmentNews.getAuthor())
                    .executeUpdate()
                    .getKey();
            departmentNews.setId(id);
        }catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<DepartmentNews> getAllDepartmentNews() {
        String sql = "SELECT * FROM news";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql, true)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(DepartmentNews.class);
        }catch (Sql2oException ex){
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public DepartmentNews getDepartmentNewsById(int id) {
        String sql = "SELECT * FROM news WHERE deparmentId=:id";
        try (Connection conn = sql2o.open()){
            return   conn.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .addParameter("id", id)
                    .executeAndFetchFirst(DepartmentNews.class);
        }catch (Sql2oException ex){
            System.out.println(ex);
            return null;
        }



    }
}
