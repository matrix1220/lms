package lms.server.dao;

//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import lms.server.Server;

//import java.security.SecureRandom;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.List;

public class Book extends lms.api.Book {
    public Book(int id, String title, String subject, String author, String ISBN, String publish_date) {
        super(id, title, subject, author, ISBN, publish_date);
    }

    public Book(String title, String subject, String author, String ISBN, String publish_date) {
        super(title, subject, author, ISBN, publish_date);
    }
    public Book(lms.api.Book book) {
        super(book.id, book.title, book.subject, book.author, book.ISBN, book.publish_date);
    }

    public boolean create() throws Throwable {
        PreparedStatement statement = Server.connection.prepareStatement(
                "INSERT INTO books(title, subject, author, ISBN, publish_date) VALUES(?,?,?,?,?)"
        );
        statement.setString(1, title);
        statement.setString(2, subject);
        statement.setString(3, author);
        statement.setString(4, ISBN);
        statement.setString(5, publish_date);
        boolean result = statement.executeUpdate() > 0;
        statement.close();
        return result;
    }

    public static ArrayList<Book> read() throws Throwable {
        PreparedStatement statement = Server.connection.prepareStatement("SELECT * FROM books");
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Book> result = new ArrayList();
        while (resultSet.next()) {
            result.add(new Book(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("subject"),
                    resultSet.getString("author"),
                    resultSet.getString("ISBN"),
                    resultSet.getString("publish_date")
            ));
        }
        statement.close();
        return result;
    }

    public static Book read(int id) throws Throwable {
        PreparedStatement statement = Server.connection.prepareStatement("SELECT * FROM books WHERE id = ?");
        statement.setInt(1, id);
        Book book = null;
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            book = new Book(
                    resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("subject"),
                    resultSet.getString("author"),
                    resultSet.getString("ISBN"),
                    resultSet.getString("publish_date")
            );
        }
        statement.close();
        return book;

    }

    public boolean update() throws Throwable {
        PreparedStatement statement = Server.connection.prepareStatement("UPDATE books SET title = ?, subject = ?, " +
        "author = ?, ISBN = ? , publish_date = ? WHERE id = ?");
        statement.setString(1, title);
        statement.setString(2, subject);
        statement.setString(3, author);
        statement.setString(4, ISBN);
        statement.setString(5, publish_date);
        statement.setInt(6, id);
        boolean result = statement.executeUpdate() > 0;
        statement.close();
        return result;
    }

    public boolean delete() throws Throwable {
        PreparedStatement statement = Server.connection.prepareStatement("DELETE FROM books where id = ?");
        statement.setInt(1, id);
        boolean result = statement.executeUpdate() > 0;
        statement.close();
        return result;
    }

    public static ArrayList<Book> search(String data) throws Throwable {
        String stmt = "SELECT * FROM books WHERE title = ? OR subject = ? " +
        "OR author = ? OR ISBN = ? OR publish_date = ?";
        PreparedStatement statement = Server.connection.prepareStatement(stmt);
        for(int i = 1 ; i <=5 ; i++)
        {
            statement.setString(i,data);
        }
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Book> result = new ArrayList();
        while(resultSet.next())
        {
            result.add(
                    new Book(
                            resultSet.getInt("id"),
                            resultSet.getString("title"),
                            resultSet.getString("subject"),
                            resultSet.getString("author"),
                            resultSet.getString("ISBN"),
                            resultSet.getString("publish_date")
                    )
            );
        }
        statement.close();
        return result;
        
    }
}