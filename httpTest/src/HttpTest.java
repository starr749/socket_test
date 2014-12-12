package httpTest.src;

import org.quickconnectfamily.json.JSONInputStream;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by starr_000 on 11/24/2014.
 */
public class HttpTest {

    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String args[] ) throws Exception {
        HttpTest test = new HttpTest();

        test.getPokemon();
    }

    private void getPokemon() throws Exception {

        String url = "http://pokeapi.co/api/v1/pokemon/1";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to: " + url);
        System.out.println("Response Code : " + responseCode);

        JSONInputStream inFromServer = new JSONInputStream(con.getInputStream());

        HashMap map = (HashMap) inFromServer.readObject();
        System.out.println(map);

    }
}
