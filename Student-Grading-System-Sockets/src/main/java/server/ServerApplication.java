package server;

import server.data.crud.student.StudentCrudImpl;
import server.data.crud.studentsCourses.StudentsCoursesCrudImpl;
import server.services.LoginService;
import server.services.MarksService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerApplication {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private final int PORT = 8080;
    private static ExecutorService executorService;

    public void start() throws IOException {
        serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            clientSocket = serverSocket.accept();
            System.out.println("Client connected");
            executorService.execute(new ClientHandler(clientSocket,
                    new LoginService(new StudentCrudImpl()),
                    new MarksService(new StudentsCoursesCrudImpl())));
        }

    }

    public static void main(String[] args){

        executorService = Executors.newFixedThreadPool(10);
        try {
            new ServerApplication().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
