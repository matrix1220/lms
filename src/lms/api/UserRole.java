package lms.api;

public enum UserRole {
	none(0),
	administrator(1),
	librarian(2),
	student(3);

	UserRole(int code) {
		this.code = code;
	}
	public final int code;
	public static UserRole get(int code) {
		switch(code) {
			case 0: return UserRole.none;
			case 1: return UserRole.administrator;
			case 2: return UserRole.librarian;
			case 3: return UserRole.student;
		}
		return UserRole.none;
	}
}