package lms.client;

// https://www.javatpoint.com/socket-programming
import java.io.*;
import java.net.*;
//import java.net.Socket;

public class Client {
	public Socket socket;
    public ObjectInputStream input;
    public ObjectOutputStream output;
    public User user;
    //private int id = 0;

    public Client() throws Throwable {
        this("localhost", 8056);
    }
    public Client(String host, int port) throws Throwable {
        //System.out.println("creating client");
        socket = new Socket(host, port);
        output = new ObjectOutputStream(socket.getOutputStream());
        input = new ObjectInputStream(socket.getInputStream());
        user = new User(this);
    }
    void close() throws Throwable {
        System.out.println("closing");
        output.writeInt(0);
        output.flush();

        output.close();
        input.close();
        socket.close();
    }
    // Client(String login, String password) {
    //     this();
    //     authenticate(login, password);
    // }

    // public void call(int method) {
    //     output.writeObject(method);
    // }
}