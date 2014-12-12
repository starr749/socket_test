package socketserver;

import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by starr_000 on 11/21/2014.
 */
public class SocketExecutor {
    private static final int HANDLERS = 10;
    private ExecutorService pool = null;
    public static SocketHandler listener;

    public SocketExecutor() {
        try {
            pool = Executors.newFixedThreadPool(HANDLERS);
            listener = new SocketHandler();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SocketExecutor socketServer = new SocketExecutor();
        SocketExecutor.listener.listen();
    }

    public class SocketHandler {
        private ServerSocket listener = null;

        public SocketHandler() throws IOException {
            listener = new ServerSocket(8100);
        }

        public void listen() {

            try {
                System.out.println("Socket Server is running");

                while (true) {
                    //wait for a connection
                    System.out.println("Waiting for connection");
                    final Socket clientSocket = listener.accept();
                    RequestHandler handler = new RequestHandler(clientSocket);
                    pool.execute(handler);
                }
            } catch (Exception e) {
                e.printStackTrace();
                pool.shutdown();
            }
        }
    }


    class RequestHandler implements Runnable {
        private final Socket socket;

        public RequestHandler(Socket socket) {
                this.socket = socket;
            }

        public void run() {

            try {
                   //setup streams
                JSONInputStream inFromClient = new JSONInputStream(socket.getInputStream());
                JSONOutputStream outToClient = new JSONOutputStream(socket.getOutputStream());

                while (true) {
                    System.out.println("Have a connection, waiting for message");
                    HashMap map = (HashMap) inFromClient.readObject();
                    System.out.println("Got: " + map + " from client");
                    Communication response = new Communication();
                    if (map.get("data") != null) {
                        response.setAction("Completed");
                        response.setData(map.get("data"));
                    } else {
                        response.setAction("Completed");
                        response.setData(map.toString());
                    }
                    outToClient.writeObject(response);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}

