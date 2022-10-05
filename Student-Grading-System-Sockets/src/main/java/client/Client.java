package client;

import java.io.IOException;

public class Client {


    public static void main(String[] args){
        final String HOST = "localhost";
        final int PORT = 8080;

        ClientBackend clientBackend = new ClientBackend(HOST, PORT);

        try{
            clientBackend.start();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
