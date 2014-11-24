package socketserver;

import java.io.*;
import java.net.Socket;
import java.util.EmptyStackException;
import java.util.HashMap;

import org.quickconnectfamily.json.*;
import sun.invoke.empty.Empty;

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

            testSocket(outToServer, inFromServer);
        }
        catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void testSocket(JSONOutputStream outToServer, JSONInputStream inFromServer) {
        Communication request = new Communication("Test", "This is a test");
        Player bob = new Player();
        bob.setName("Bob");
        bob.setLevel(5);
        bob.setAttack(6);
        try {
            outToServer.writeObject(request);
            HashMap map = (HashMap) inFromServer.readObject();
            System.out.println(map);

            request.setData(1);
            outToServer.writeObject(request);
            map = (HashMap) inFromServer.readObject();
            System.out.println(map);

            int[] array = {1,2,3,4};
            request.setData(array);
            outToServer.writeObject(request);
            map = (HashMap) inFromServer.readObject();
            System.out.println(map);

            outToServer.writeObject(bob);
            map = (HashMap) inFromServer.readObject();
            System.out.println(map);

            request.setData(bob);
            outToServer.writeObject(request);
            map = (HashMap) inFromServer.readObject();
            System.out.println(map);

            Fighter pet = new Fighter();
            pet.setAttack(5);
            pet.setName("Gary");
            pet.setDefense(6);

            Enemy rival = new Enemy();
            rival.setName("Vladimir");
            rival.setDefense(2);
            rival.setAttack(7);

            bob.setPet(pet);
            outToServer.writeObject(bob);
            map = (HashMap) inFromServer.readObject();
            System.out.println(map);

            bob.setRival(rival);
            request.setData(bob);
            outToServer.writeObject(request);
            map = (HashMap) inFromServer.readObject();
            System.out.println(map);


//              CANT DO THIS BECAUSE PET ISN'T SERIALIZABLE!!
//            outToServer.writeObject(pet);
//            map = (HashMap) inFromServer.readObject();
//            System.out.println(map);

            request.setData(pet);
            outToServer.writeObject(request);
            map = (HashMap) inFromServer.readObject();
            System.out.println(map);

            outToServer.writeObject(null);
            map = (HashMap) inFromServer.readObject();
            System.out.println(map);

            request.setData(null);
            map = (HashMap) inFromServer.readObject();
            System.out.println(map);

            } catch (Exception e) {
            System.out.println(e);
        }
    }
}
