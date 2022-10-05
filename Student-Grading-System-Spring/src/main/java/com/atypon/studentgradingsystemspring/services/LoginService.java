package com.atypon.studentgradingsystemspring.services;

import com.atypon.studentgradingsystemspring.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.atypon.studentgradingsystemspring.data.crud.student.StudentCrudImpl;

import java.util.List;

@Service
@AllArgsConstructor
public class LoginService {

    private final StudentCrudImpl StudentCrudImpl;


    public boolean validate(String username, String password) {
        Student student = StudentCrudImpl.findByUsername(username);
        return student != null && student.getPassword().equals(password);
    }

    public List<Student> getAllStudents() {
        return StudentCrudImpl.findAll();
    }

}
