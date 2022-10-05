package server.data.crud.student;

import server.model.Student;

import java.util.List;
public interface StudentCrud{

    Integer save(Student student);

    Student findByUsername(String username);

    List<Student> findAll();
}
