package lms.server;

import lms.api.UserRole;

public class User {
	public UserRole role = UserRole.none;
	public Client client;
	public User(Client client) {
		this.client = client;
	}
	public User(Client client, UserRole role) {
		this(client);
		this.role = role;
	}
	public void call(int method) throws Throwable {
		switch(method) {
			case 1: login(); break;
			case 2: logout(); break;
		}
	}
	public void login() throws Throwable {
		String username = (String) client.input.readObject();
        String password = (String) client.input.readObject();
        System.out.println("logging in " + username + " " + password);
        lms.server.dao.User user = lms.server.dao.User.read(username, password);
        //System.out.println(user.id + " " + user.role.code);

        client.output.writeObject((lms.api.User) user);
        //client.output.writeObject(user);
        if(user.role==UserRole.administrator) {
            client.user = new Administrator(client);
        } else if(user.role==UserRole.librarian) {
            client.user = new Librarian(client);
        } else if(user.role==UserRole.student) {
            client.user = new Student(client);
        }
	}
	public void logout() throws Throwable {
		client.user = new User(client);
	}

}