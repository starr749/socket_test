package socketserver;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;
import org.quickconnectfamily.json.JSONUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Sidus on 11/23/2014.
 */
public class FileIO {

    public static Object loadPlayer() {
        File file = new File("player.json");
        Object player = null;
        try {
            FileInputStream fileStream = new FileInputStream(file);
            JSONInputStream jsonIn = new JSONInputStream(fileStream);
            player = jsonIn.readObject();
            jsonIn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return player;
    }

    public static void savePlayer(Player player) {
        File file = new File("player.json");
        try {
            FileOutputStream fileStream = new FileOutputStream(file);
            JSONOutputStream jsonOut = new JSONOutputStream(fileStream);
            jsonOut.writeObject(player);
            jsonOut.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void main(String args[]) {
        Player test = new Player();
        test.setName("Bob");
        test.setAttack(5);
        test.setDefense(6);
        test.setHp(50);

        savePlayer(test);

        System.out.println(loadPlayer());
    }
}
