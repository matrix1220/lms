package lms.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import lms.client.Client;


public class UI extends Application {

    public static Stage primaryStage;

    public static void startLibrarianController(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(UI.class.getResource("Librarian/LibrarianWindow.fxml"));
        primaryStage.getIcons().add(new Image("file:///D:/JavaF/group-project-404/images/icon.png"));
        primaryStage.setTitle("IUT Library Management System");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
    public static void startAdminController(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(UI.class.getResource("Admin/AdminWindow.fxml"));
        primaryStage.getIcons().add(new Image("file:///D:/JavaF/group-project-404/images/icon.png"));
        primaryStage.setTitle("IUT Library Management System");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
    public static void startLogin(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(UI.class.getResource("login.fxml"));
        primaryStage.getIcons().add(new Image("file:///D:/JavaF/group-project-404/images/icon.png"));
        primaryStage.setTitle("IUT Library Management System");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }


    public static void main(String[] args) throws Throwable {
        client = new Client();
        //client.close();
        launch(args);
    }
    public static Client client;

    @Override
    public void start(Stage primaryStage) throws Exception {
        UI.primaryStage = primaryStage;
        primaryStage.getIcons().add(new Image("file:///D:/JavaF/group-project-404/images/icon.png"));
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("IUT Library Management System");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}