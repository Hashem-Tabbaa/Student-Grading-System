package services;

import data.crud.student.StudentCrud;
import model.Student;

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
