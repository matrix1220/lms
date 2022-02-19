package lms.client;
import java.util.ArrayList;
import lms.api.UserRole;


public class Librarian extends User {
	public Librarian(Client client) {
		super(client, UserRole.librarian);
	}
	public boolean create(lms.api.Book book) throws Throwable {
		call(20);
		client.output.writeObject(book);
		return client.input.readBoolean();
	}
	public ArrayList<lms.api.Book> read() throws Throwable {
		call(21);
		ArrayList<lms.api.Book> tmp = new ArrayList<lms.api.Book>();
		while (client.input.readBoolean()) {
			tmp.add((lms.api.Book) client.input.readObject());
		}
        return tmp;
	}
	public boolean update(lms.api.Book book) throws Throwable {
		call(22);
		client.output.writeObject(book);
		return client.input.readBoolean();
	}
	public boolean delete(lms.api.Book book) throws Throwable {
		call(23);
		client.output.writeObject(book);
		return client.input.readBoolean();
	}
}