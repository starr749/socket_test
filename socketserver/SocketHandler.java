package socketserver;

import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * Created by Sidus on 11/18/2014.
 */
public class SocketHandler {
    public static void main(String[] args) throws Exception {

        try {
            ServerSocket listener = new ServerSocket(8100);
            System.out.println("Socket Server is running");

            while (true) {
                //wait for a connection
                System.out.println("Waiting for connection");
                Socket clientSocket = listener.accept();

                //setup streams
                JSONInputStream inFromClient = new JSONInputStream(clientSocket.getInputStream());
                JSONOutputStream outToClient = new JSONOutputStream(clientSocket.getOutputStream());

                while (true) {
                    System.out.println("Have a connection, waiting for message");
                    HashMap map = (HashMap)inFromClient.readObject();
                    System.out.println("Got: " + map + " from client");
                    Communication response = new Communication("Completed", map.get("data"));
                    outToClient.writeObject(response);
                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
