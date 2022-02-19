package lms.ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import lms.api.UserRole;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class LoginController {
	@FXML
	TextField username;
	@FXML
	PasswordField password;

    @FXML
    public void handleSubmit(ActionEvent event) throws Throwable {

	    UI.client.user.login(username.getText(), password.getText());
	    if (UI.client.user.role==UserRole.administrator) {
	    	UI.startAdminController(UI.primaryStage);
	    } else if (UI.client.user.role==UserRole.librarian) {
	    	UI.startLibrarianController(UI.primaryStage);
	    } else if (UI.client.user.role==UserRole.student) {
	    } else {}
	   	// switch(UI.client.user.role.code) {
	   	// 	case UserRole.none.code:
	   	// 		// error
	   	// 		break;
	   	// 	case UserRole.administrator.code:
	   	// 		UI.startAdminController(UI.primaryStage);
	   	// 		break;
	   	// 	case UserRole.librarian.code:
	   	// 		UI.startLibrarianController(UI.primaryStage);
	   	// 		break;
	   	// 	case UserRole.student.code:
	   	// 		break;
	   	// }
	}

        //if librarian id entered
//        UI.startLibrarianController(UI.primaryStage);

        //if admin id entered
         //UI.startAdminController(UI.primaryStage);


};


