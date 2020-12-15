package models;

import java.util.Objects;

public class DepartmentNews {
    private int id;
    private int departmentId;
    private String title;
    private String news;
    private String author;

    public DepartmentNews(int departmentId, String title, String news, String author) {
        this.departmentId = departmentId;
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

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
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
        if (!(o instanceof DepartmentNews)) return false;
        DepartmentNews that = (DepartmentNews) o;
        return getId() == that.getId() &&
                Objects.equals(getDepartmentId(), that.getDepartmentId()) &&
                Objects.equals(getTitle(), that.getTitle()) &&
                Objects.equals(getNews(), that.getNews()) &&
                Objects.equals(getAuthor(), that.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDepartmentId(), getTitle(), getNews(), getAuthor());
    }
}

