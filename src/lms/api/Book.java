package lms.api;

import java.io.Serializable;

public class Book implements Serializable {
    public int id;
    public String title;
    public String subject;
    public String author;
    public String ISBN;
    public String publish_date;

    public Book(int id, String title, String subject, String author, String ISBN, String publish_date) {
        this.id = id;
        this.title = title;
        this.subject = subject;
        this.author = author;
        this.ISBN = ISBN;
        this.publish_date = publish_date;
    }
    public Book(String title, String subject, String author, String ISBN, String publish_date) {
        this.title = title;
        this.subject = subject;
        this.author = author;
        this.ISBN = ISBN;
        this.publish_date = publish_date;
    }

}