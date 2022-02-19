module group.project {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;

    opens lms.ui;
    opens lms.ui.Admin;
    opens lms.ui.Librarian;
}