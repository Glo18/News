package dao;

import models.GeneralNews;

import java.util.List;

public interface GeneralNewsDao {
    // create
    void add (GeneralNews generalNews);

    //Read
    List<GeneralNews> getAllGeneralNews();

    GeneralNews getGeneralNewsById(int id);
}
