package models;

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
}
