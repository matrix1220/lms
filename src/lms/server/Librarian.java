package lms.server;

public class Librarian extends User {
	public Librarian(Client client) {
		super(client);
		//methods.put(3, this::login);
	}
	public void call(int method) throws Throwable {
		switch(method) {
			case 20: create(); return;
			case 21: read(); return;
			case 22: update(); return;
			case 23: delete(); return;
		}
		super.call(method);
	}
	public void read() throws Throwable {
		//System.out.println("read");
        for (lms.server.dao.Book book : lms.server.dao.Book.read()) {
    		client.output.writeBoolean(true);
    		client.output.writeObject(book);
    	}
    	client.output.writeBoolean(false);
    	//client.output.flush();
	}
	public void create() throws Throwable {
		lms.server.dao.Book book = new lms.server.dao.Book((lms.api.Book) client.input.readObject());
		client.output.writeBoolean(book.create());
	}
	public void update() throws Throwable {
		lms.server.dao.Book book = new lms.server.dao.Book((lms.api.Book) client.input.readObject());
		client.output.writeBoolean(book.update());
	}
	public void delete() throws Throwable {
		lms.server.dao.Book book = new lms.server.dao.Book((lms.api.Book) client.input.readObject());
		client.output.writeBoolean(book.delete());
	}
	
}