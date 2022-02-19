package lms.server;


// https://habr.com/ru/post/69136/
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.sql.Connection;
import java.sql.DriverManager;

public class Server {

    public static Connection connection;
    public static void main(String[] args) throws Throwable {
        final String DATABASE_URL = "jdbc:derby:./db/db";
        connection = DriverManager.getConnection(DATABASE_URL);
        ServerSocket serverSocket = new ServerSocket(8056);
        System.out.println("Server is up!");
        while (true) {
            Socket socket = serverSocket.accept();
            //System.out.println("Client accepted");
            new Thread(new SocketProcessor(socket)).start();
        }
    }

    private static class SocketProcessor implements Runnable {
        Socket socket;
        Client client;
        SocketProcessor(Socket socket) throws Throwable {
            this.socket = socket;
            client = new Client(socket);
        }

        public void run() {
            try {
                client.handle();
            } catch (Throwable t) {
                /*do nothing*/
                // System.out.println(t)
            } finally {
                try {
                    socket.close();
                } catch (Throwable t) {
                    /*do nothing*/
                }
            }
            //System.err.println("Client processing finished");
        }

    }
}

// System.out.println

class Client {

    //Socket socket;
    ObjectInputStream input;
    ObjectOutputStream output;
    User user;

    Client(Socket socket) throws Throwable {
        //this.socket = socket;
        // https://stackoverflow.com/questions/14110986/new-objectinputstream-blocks/14111047
        output = new ObjectOutputStream(socket.getOutputStream());
        input = new ObjectInputStream(socket.getInputStream());
        user = new User(this);
    }
    public void handle() throws Throwable {
        int method;
        while(true) {
            System.out.println("reading method");
            method = input.readInt();
            if(method==0) {
                System.out.println("closing");
                break;
            }
            user.call(method);
            output.flush();
        }
        output.close();
        input.close();
        //socket.close();
    }
}