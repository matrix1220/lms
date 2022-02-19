package lms.server.dao;

import lms.api.UserRole;
import java.util.ArrayList;
//import server.Server;
import lms.server.Server;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class User extends lms.api.User {
	public User() {
	}
	public User(int id, UserRole role, String username, String password) {
		super(id, role, username, password);
	}
	public User(UserRole role, String username, String password) {
		super(role, username, password);
	}
        public User(lms.api.User user) {
                this.id = user.id;
                this.role = user.role;
                this.username = user.username;
                this.password = user.password;
        }
	public boolean create() throws Throwable {
		PreparedStatement statement = Server.connection.prepareStatement("INSERT INTO users (role, username, password) VALUES (?, ?, ?)");
                statement.setInt(1, role.code);
                statement.setString(2, username);
                statement.setString(3, password);
                boolean result = statement.executeUpdate() > 0;
                statement.close();
                return result;
	}

	public static ArrayList<User> read() throws Throwable {
		PreparedStatement statement = Server.connection.prepareStatement("SELECT * FROM users");
                ResultSet resultSet = statement.executeQuery();
                ArrayList<User> result = new ArrayList<User>();
                while(resultSet.next()) {
                	User user = new User(
                                resultSet.getInt("id"),
                		UserRole.get(resultSet.getInt("role")),
                		resultSet.getString("username"),
                		resultSet.getString("password")
                	);
                	result.add(user);
                }
                statement.close();
                return result;
	}
        public static User read(String username, String password) throws Throwable {
                PreparedStatement statement = Server.connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
                statement.setString(1, username);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();
                User user = new User();
                if(resultSet.next()) {
                        user = new User(
                                resultSet.getInt("id"),
                                UserRole.get(resultSet.getInt("role")),
                                resultSet.getString("username"),
                                resultSet.getString("password")
                        );
                }
                return user;
        }
        public boolean update() throws Throwable {
                PreparedStatement statement = Server.connection.prepareStatement("UPDATE users SET role = ?, username = ?, " +
                "password = ? WHERE id = ?");
                statement.setInt(1, role.code);
                statement.setString(2, username);
                statement.setString(3, password);
                statement.setInt(4, id);
                boolean result = statement.executeUpdate() > 0;
                statement.close();
                return result;
        }
        public boolean delete() throws Throwable {
                PreparedStatement statement = Server.connection.prepareStatement("DELETE FROM users where id = ?");
                statement.setInt(1, id);
                boolean result = statement.executeUpdate() > 0;
                statement.close();
                return result;
        }

}