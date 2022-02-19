package lms.client;

import lms.api.UserRole;

public class User {
	public UserRole role = UserRole.none;
	Client client;
	public User(Client client) {
		//System.out.println("creating user");
		this.client = client;
	}
	public User(Client client, UserRole role) {
		this(client);
		this.role = role;
	}
	public void call(int method) throws Throwable {
		client.output.writeInt(method);
		client.output.flush();
	}

	public void login(String username, String password) throws Throwable {
		System.out.println("logging in " + username + " " + password);
		call(1);
		client.output.writeObject(username);
        client.output.writeObject(password);

        lms.api.User user = (lms.api.User) client.input.readObject();
        //System.out.println(user.username + " " + user.role.code);

        if(user.role==UserRole.administrator) {
            client.user = new Administrator(client);
        } else if(user.role==UserRole.librarian) {
            client.user = new Librarian(client);
        } else if(user.role==UserRole.student) {
            client.user = new Student(client);
        }
        //System.out.println("success");
	}
	public void logout() throws Throwable {
		//System.out.println("logging out");
		call(2);
		client.user = new User(client);
	}
}