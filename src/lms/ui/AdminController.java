package lms.ui;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.util.Optional;
public class AdminController {

    @FXML
    public Pane dataPane=null;
    @FXML
    private TextField txtSearch;
    @FXML
    public Label txtTitle;
    @FXML
    public Label txtSubject;
    @FXML
    public Label txtAuthor;
    @FXML
    public Label txtISBN;
    @FXML
    public Label txtYear;

    public void initialize() throws IOException {
        System.out.println("initialized22");
        // Pane librarianPane = FXMLLoader.load(getClass().getResource("bookData.fxml"));
        // dataPane.getChildren().add(librarianPane);
    }
    @FXML
    public void logout(ActionEvent event) throws Throwable {
        UI.startLogin(UI.primaryStage);
        UI.client.user.logout();
    }

    @FXML
    public void toLibrarianScene(ActionEvent event) throws IOException {
        dataPane.getChildren().clear();
        Pane librarianPane = FXMLLoader.load(getClass().getResource("Admin/LibrarianData.fxml"));
        dataPane.getChildren().add(librarianPane);
    }
    @FXML
    public void toStudentScene(ActionEvent event) throws IOException{
        dataPane.getChildren().clear();
        Pane librarianPane = FXMLLoader.load(getClass().getResource("Admin/LibrarianData.fxml"));
        dataPane.getChildren().add(librarianPane);
    }
    @FXML
    public void toBookScene(ActionEvent event) throws IOException {
        dataPane.getChildren().clear();
        Pane bookPane = FXMLLoader.load(getClass().getResource("Admin/bookData.fxml"));
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
            //Book should be added
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
        } catch (IOException ex) {
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
    public  void addLibrarian(ActionEvent event) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Add A New Librarian");

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
            //Librarian should be added
            Alert info = new Alert(Alert.AlertType.INFORMATION);

            info.setTitle("Librarian Added");
            info.setHeaderText("Librarian Details Were Successfully Added");
            info.show();
        }
    }

    @FXML
    public void deleteLibrarian(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle("Delete This Librarian");
        alert.setHeaderText("Delete Librarian: "); // Here should be librarian details
        alert.setContentText("Are you sure?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            //Librarian should be removed
        }
    }

    @FXML
    public void modifyLibrarian(ActionEvent event) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Modify This Student");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("userModifyWindow.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException ex) {
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
    public TextField TxtSearch;
    @FXML
    public void searchBooks(ActionEvent actionEvent)
    {
        System.out.println("Searched by Admin "+txtSearch.getText());
        txtSearch.setText("");
    }
    @FXML
    public void reloadBooks(ActionEvent actionEvent) {
        System.out.println("Reloaded by Admin");
    }
    @FXML
    public TextField txtSearchUsers;
    @FXML
    public void searchUsers(ActionEvent actionEvent)
    {
        System.out.println("Searched by admin" + txtSearchUsers.getText());
        txtSearchUsers.setText("");
    }

}
