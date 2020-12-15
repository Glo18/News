package dao;

import models.GeneralNews;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oGeneralNewsDao implements GeneralNewsDao {
    private final Sql2o sql2o;

    public Sql2oGeneralNewsDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(GeneralNews generalNews) {
        String sql = "INSERT INTO news (title, news, author) VALUES (:title, :news, :author)";
        try (Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .throwOnMappingFailure(false)
                    .bind(generalNews)
                    .addParameter("title", generalNews.getTitle())
                    .addParameter("news", generalNews.getNews())
                    .addParameter("author", generalNews.getAuthor())
                    .executeUpdate()
                    .getKey();
            generalNews.setId(id);
        }catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
    @Override
    public List<GeneralNews> getAllGeneralNews() {
        String sql = "SELECT * FROM news WHERE departmentId IS NULL";
//        String sql = "SELECT * FROM news";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(GeneralNews.class);
        }catch (Sql2oException ex){
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public GeneralNews getGeneralNewsById(int id) {
        String sql = "SELECT * FROM news WHERE id =:id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .addParameter("id", id)
                    .executeAndFetchFirst(GeneralNews.class);
        } catch (Sql2oException ex) {
            System.out.println(ex);
            return null;
        }
    }
}
