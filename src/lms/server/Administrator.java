package lms.server;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lms.api.UserRole;

public class Administrator extends User  {
	public Administrator(Client client) {
		super(client);
	}

	public void call(int method) throws Throwable {
		switch(method) {
			case 10: create(); return;
			case 11: read(); return;
			case 12: update(); return;
			case 13: delete(); return;
		}
		super.call(method);
	}
	public void read() throws Throwable {
		//System.out.println("read");
        for (lms.server.dao.User user : lms.server.dao.User.read()) {
    		client.output.writeBoolean(true);
    		client.output.writeObject(user);
    	}
    	client.output.writeBoolean(false);
    	//client.output.flush();
	}
	public void create() throws Throwable {
		lms.server.dao.User user = new lms.server.dao.User((lms.api.User) client.input.readObject());
		client.output.writeBoolean(user.create());
	}
	public void update() throws Throwable {
		lms.server.dao.User user = new lms.server.dao.User((lms.api.User) client.input.readObject());
		client.output.writeBoolean(user.update());
	}
	public void delete() throws Throwable {
		lms.server.dao.User user = new lms.server.dao.User((lms.api.User) client.input.readObject());
		client.output.writeBoolean(user.delete());
	}
}