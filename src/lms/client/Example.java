package lms.client;

import lms.api.UserRole;

public class Example {
	public static void main(String[] args) throws Throwable {
		Client client = new Client();
		//client.user.login("username", "password");
		client.user.login("2", "2");
		//System.out.println("success");
		User user = client.user;
		//System.out.println(user.role.code);

		if(user.role==UserRole.administrator) {
			Administrator admin = (Administrator) user;
			// lms.api.User tmp = new lms.api.User(UserRole.administrator, "username52", "passwwd");
			// admin.create(tmp);
			// System.out.println("create");
			// for (lms.api.User i : admin.read()) {
			// 	System.out.println(i.username);
			// 	//if(i.id>1) i.username = i.username + 'a';
			// 	//admin.update(i);
			// 	//admin.delete(i);
			// }
			System.out.println("update");
			for (lms.api.User i : admin.read()) {
				System.out.println(i.username + " " + i.password + " " + i.role.code);
			}
		} else if(user.role==UserRole.librarian) {
			Librarian librarian = (Librarian) user;
			lms.api.Book tmp = new lms.api.Book("title", "subject", "author", "ISBN", "publish_date");
			librarian.create(tmp);
			System.out.println("create");
			for (lms.api.Book i : librarian.read()) {
				System.out.println(i.title);
			}
		}
		client.close();
	}
}