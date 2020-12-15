package models;

import java.util.Objects;

public class GeneralNews {
    private int id;
    private String title;
    private String news;
    private String author;

    public GeneralNews(String title, String news, String author) {
        this.title = title;
        this.news = news;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GeneralNews)) return false;
        GeneralNews that = (GeneralNews) o;
        return id == that.id &&
                Objects.equals(title, that.title) &&
                Objects.equals(news, that.news) &&
                Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, news, author);
    }
}
