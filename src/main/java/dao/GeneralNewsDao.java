package dao;

import models.GeneralNews;

import java.util.List;

public interface GeneralNewsDao {
    void add (GeneralNews generalNews);

    List<GeneralNews> getAllGeneralNews();

    GeneralNews getGeneralNewsById(int id);
}
