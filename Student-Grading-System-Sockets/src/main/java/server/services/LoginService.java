package server.services;

import server.data.DBConnection;
import server.data.crud.student.StudentCrud;
import server.data.crud.student.StudentCrudImpl;
import server.model.Student;
import server.model.StudentsCourses;

import java.sql.Connection;
import java.sql.SQLException;

public class LoginService {

    private final StudentCrud studentCrud;

    public LoginService(StudentCrud studentCrud){
        this.studentCrud = studentCrud;
    }

    public Student validate(String username, String password){
        Student student = studentCrud.findByUsername(username);
        if(student == null)
            return null;
        if(student.getPassword().equals(password))
            return student;
        return null;
    }


}
