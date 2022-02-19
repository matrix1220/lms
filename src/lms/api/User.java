package lms.api;

import java.io.Serializable;

public class User implements Serializable {
	public int id;
	public UserRole role = UserRole.none;
	public String username;
	public String password;

	public User() {
	}
	public User(int id, UserRole role, String username, String password) {
		this.id = id;
		this.role = role;
		this.username = username;
		this.password = password;
	}
	public User(UserRole role, String username, String password) {
		this.role = role;
		this.username = username;
		this.password = password;
	}


}