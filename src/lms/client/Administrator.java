package lms.client;
import java.util.ArrayList;

//import lms.api.Book;
import lms.api.UserRole;

public class Administrator extends User  {
	public Administrator(Client client) {
		super(client, UserRole.administrator);
	}
	public boolean create(lms.api.User user) throws Throwable {
		call(10);
		client.output.writeObject(user);
		return client.input.readBoolean();
	}
	public ArrayList<lms.api.User> read() throws Throwable {
		call(11);
		ArrayList<lms.api.User> tmp = new ArrayList<lms.api.User>();
		while (client.input.readBoolean()) {
			tmp.add((lms.api.User) client.input.readObject());
		}
        return tmp;
	}
	public boolean update(lms.api.User user) throws Throwable {
		call(12);
		client.output.writeObject(user);
		return client.input.readBoolean();
	}
	public boolean delete(lms.api.User user) throws Throwable {
		call(13);
		client.output.writeObject(user);
		return client.input.readBoolean();
	}
}