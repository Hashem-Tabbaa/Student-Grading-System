package server;

import server.data.crud.studentsCourses.StudentsCoursesCrud;
import server.exceptions.InvalidLoginException;
import server.model.Course;
import server.model.Statistics;
import server.model.Student;
import server.model.StudentsCourses;
import server.services.LoginService;
import server.services.MarksService;


import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

public class ClientHandler implements Runnable{

    private final Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private final LoginService loginService;
    private final MarksService marksService;
    private final ObjectOutputStream objectOutputStream;
    private Student studentUser;

    public ClientHandler(Socket clientSocket, LoginService loginService,
                         MarksService markService) throws IOException {
        this.clientSocket = clientSocket;
        this.loginService = loginService;
        this.marksService = markService;

        this.out = new PrintWriter(clientSocket.getOutputStream());
        this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        this.objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
    }

    @Override
    public void run() {

        try {
            login();
        }catch (InvalidLoginException e) {
            //send response to client
            out.println("Invalid login");
            out.flush();
            try {
                clientSocket.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            return;
        }
        System.out.println("Client logged in");

        //send response to the client
        out.println("Welcome to the server, you are logged in");
        out.flush();

        // print the client's courses and marks
        out.println("Your courses and their marks are: ");
        out.flush();

        List<StudentsCourses> studentsCourses = marksService.getStudentCourses(studentUser.getUsername());
        try {
            objectOutputStream.writeObject(studentsCourses);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // ask the client to enter the course number
        out.println("Enter the course number to see the the class statistics: ");
        out.flush();

        // read the course number
        String courseNumber = null;
        try {
            courseNumber = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int courseNumberInt = Integer.parseInt(courseNumber);
        System.out.println("Client entered course number: " + courseNumberInt);
        if(courseNumberInt < 0 || courseNumberInt >= studentsCourses.size()){
            out.println("Invalid course number");
            out.flush();
            return;
        }
        out.println("Valid course number, the class course statistics are: ");
        out.flush();

        // create a list of statistics for the selected course
        List<Statistics> statistics = new Vector<>();
        String course = studentsCourses.get(courseNumberInt).getCourse_name();
        statistics.add(new Statistics("Average mark", marksService.getStudentAverage(course)));
        statistics.add(new Statistics("Maximum mark", marksService.getStudentMax(course)));
        statistics.add(new Statistics("Minimum mark", marksService.getStudentMin(course)));
        statistics.add(new Statistics("Median mark", marksService.getStudentMedian(course)));

        // send the list of statistics to the client
        try {
            objectOutputStream.writeObject(statistics);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private void login() throws InvalidLoginException{
        try{
            out.println("Enter username and password separated by a space");
            out.flush();
            String[] credentials = in.readLine().split(" ");
            String username = credentials[0];
            String password = credentials[1];

            System.out.println("Username: " + username + " Password: " + password);

            studentUser = loginService.validate(username, password);

            if(studentUser == null)
                throw new InvalidLoginException("Invalid login");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
