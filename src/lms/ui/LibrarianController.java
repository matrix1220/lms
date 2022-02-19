package lms.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Optional;


public class LibrarianController {

    @FXML
    public Pane dataPane;
    @FXML
    public Button toStudent;
    @FXML
    public Button toBook;
    @FXML
    public GridPane librarianMainPane;
    @FXML
    public void logout(ActionEvent event) throws Exception {
        UI.startLogin(UI.primaryStage);
    }
    @FXML
    public TextField txtTitle;
    @FXML
    public TextField txtAuthor;
    @FXML
    public TextField txtSubject;
    @FXML
    public TextField txtISBN;
    @FXML
    public TextField txtYear;
    @FXML
    public TextField txtSearch;
    @FXML
    public void toStudentScene(ActionEvent event) throws IOException{
        dataPane.getChildren().clear();
        Pane librarianPane = FXMLLoader.load(getClass().getResource("Librarian/StudentData.fxml"));
        dataPane.getChildren().add(librarianPane);
    }
    @FXML
    public void toBookScene(ActionEvent event) throws IOException {
        dataPane.getChildren().clear();
        Pane bookPane = FXMLLoader.load(getClass().getResource("Librarian/bookData.fxml"));
        dataPane.getChildren().add(bookPane);
    }

    @FXML
    public  void addBook(ActionEvent event) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Add A New Book");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("bookModifyWindow.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get()==ButtonType.OK) {
            Alert info = new Alert(Alert.AlertType.INFORMATION);

            info.setTitle("Book Added");
            info.setHeaderText("Book Details Were Successfully Added");
            info.show();
        }
    }

    @FXML
    public void deleteBook(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Delete This Book");
        alert.setHeaderText("Delete Book: "); // Here should be book details
        alert.setContentText("Are you sure?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            //Book should be removed
        }
    }

    @FXML
    public void modifyBook(ActionEvent event) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Modify This Book");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("bookModifyWindow.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            //Book should be modified

            Alert info = new Alert(Alert.AlertType.INFORMATION);

            info.setTitle("Book Modified");
            info.setHeaderText("Book Details Were Successfully Modified");
            info.show();
        }
    }

    @FXML
    public  void addStudent(ActionEvent event) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Add A New Student");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("userModifyWindow.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get()==ButtonType.OK) {
            //Student should be added
            Alert info = new Alert(Alert.AlertType.INFORMATION);

            info.setTitle("Student Added");
            info.setHeaderText("Student Details Were Successfully Added");
            info.show();
        }
    }

    @FXML
    public void deleteStudent(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Delete This Student");
        alert.setHeaderText("Delete Student: "); // Here should be student details
        alert.setContentText("Are you sure?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            //Student should be removed
        }
    }

    @FXML
    public void modifyStudent(ActionEvent event) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Modify This Student");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("userModifyWindow.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            //Student should be modified
            Alert info = new Alert(Alert.AlertType.INFORMATION);

            info.setTitle("Student Modified");
            info.setHeaderText("Student Details Were Successfully Modified");
            info.show();
        }

    }
    @FXML
    public void searchBooks(ActionEvent actionEvent)
    {
        System.out.println("Searched books:" + txtSearch.getText());
    }
    @FXML
    public void reloadBooks(ActionEvent actionEvent) {
        System.out.println("Reloaded by Librarians");
    }
    @FXML
    public TextField txtSearchUsers;
    @FXML
    public void searchUsers(ActionEvent actionEvent) {
        System.out.println("Searched by Librarian " + txtSearchUsers.getText());
    }
}
