package lms.client;

import lms.api.UserRole;

public class Student extends User {
	public Student(Client client) {
		super(client, UserRole.student);
	}
}