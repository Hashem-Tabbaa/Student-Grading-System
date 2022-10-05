package client;

import server.model.Statistics;
import server.model.StudentsCourses;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ClientBackend {

    private final int PORT;
    private final String HOST;

    public ClientBackend(String host, int port) {
        this.HOST = host;
        this.PORT = port;
    }

    public void start() throws IOException, ClassNotFoundException {
        // connect to socket server at localhost:8080
        Socket serverSocket = new Socket(HOST, PORT);
        System.out.println("Connected to server at " + HOST + ":" + PORT);

        BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        ObjectInputStream objectInputStream = new ObjectInputStream(serverSocket.getInputStream());

        //read message from server
        String serverMessage = in.readLine();
        System.out.println(serverMessage);

        //get username and password from user
        String credentials = keyboard.readLine();

        //send message to server
        out.println(credentials);

        //get response from server
        String response = in.readLine();
        System.out.println(response);
        if(response.equals("Invalid login")){
            serverSocket.close();
            return;
        }

        //read message from the server
        System.out.println(in.readLine());

        //read object from the server
        List<StudentsCourses> studentsCourses = (List<StudentsCourses>) objectInputStream.readObject();
        for(int i = 0 ; i<studentsCourses.size() ; i++){
            System.out.println(i + ". " + studentsCourses.get(i));
        }

        //get instructions from the server
        System.out.println(in.readLine());

        //get user input
        String input = keyboard.readLine();

        //send user input to the server
        out.println(input);

        //get response from the server
        String responseFromServer = in.readLine();
        System.out.println(responseFromServer);
        if(responseFromServer.equals("Invalid course number")){
            serverSocket.close();
            return;
        }

        //receive the list of statistics from the server
        List<Statistics> statistics = (List<Statistics>) objectInputStream.readObject();
        for(Statistics stat : statistics){
            System.out.println(stat);
        }

        serverSocket.close();
    }

}
