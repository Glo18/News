package models;

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
}
