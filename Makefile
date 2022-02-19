server:
	javac\
	 src/lms/server/Server.java\
	 src/lms/server/User.java\
	 src/lms/server/Administrator.java\
	 src/lms/server/Librarian.java\
	 src/lms/server/Student.java\
	 src/lms/server/dao/User.java\
	 src/lms/server/dao/Book.java\
	 src/lms/api/UserRole.java\
	 src/lms/api/User.java\
	 src/lms/api/Book.java\
	 -d bin

server_run:
	java lms.server.Server

client:
	javac\
	 src/lms/client/Client.java\
	 src/lms/client/User.java\
	 src/lms/client/Example.java\
	 src/lms/client/Administrator.java\
	 src/lms/client/Librarian.java\
	 src/lms/client/Student.java\
	 src/lms/api/UserRole.java\
	 src/lms/api/User.java\
	 src/lms/api/Book.java\
	 -d bin

client_run:
	java lms.client.Example

ui:
	javac\
	 --module-path C:\\javafx-sdk-11.0.2\\lib\
	 --add-modules javafx.controls\
	 --add-modules javafx.fxml\
	 src/lms/client/Client.java\
	 src/lms/client/User.java\
	 src/lms/client/Example.java\
	 src/lms/client/Administrator.java\
	 src/lms/client/Librarian.java\
	 src/lms/client/Student.java\
	 src/lms/api/UserRole.java\
	 src/lms/api/User.java\
	 src/lms/api/Book.java\
	 src/lms/ui/UI.java\
	 src/lms/ui/LoginController.java\
	 src/lms/ui/LibrarianController.java\
	 src/lms/ui/AdminController.java\
	 -d bin

ui_run:
	java\
	 --module-path C:\\javafx-sdk-11.0.2\\lib\
	 --add-modules javafx.controls\
	 --add-modules javafx.fxml\
	 lms.ui.UI



# javac --module-path C:\javafx-sdk-11.0.2\lib --add-modules javafx.controls --add-modules javafx.fxml src/lms/ui/UI.java src/lms/ui/fxml/Librarian/LibrarianController.java -d bin
# java --module-path C:\javafx-sdk-11.0.2\lib --add-modules javafx.controls --add-modules javafx.fxml lms.ui.UI