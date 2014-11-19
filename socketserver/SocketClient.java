package socketserver;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;

import org.quickconnectfamily.json.*;

/**
 * Created by Sidus on 11/18/2014.
 */
public class SocketClient {
    public static void main(String args[]) {
        Socket Client;

        Player test = new Player();
        test.setName("Bob");
        test.setLevel(5);
        test.setAttack(2);

        Communication request = new Communication("Test", test);



        try {
            Client = new Socket("localhost", 8100);
            JSONInputStream inFromServer = new JSONInputStream(Client.getInputStream());
            JSONOutputStream outToServer= new JSONOutputStream(Client.getOutputStream());

            outToServer.writeObject(request);

            HashMap map = (HashMap)inFromServer.readObject();
            System.out.println(map);
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }
}
