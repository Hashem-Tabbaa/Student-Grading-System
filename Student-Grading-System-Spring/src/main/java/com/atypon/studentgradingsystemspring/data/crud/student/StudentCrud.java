package com.atypon.studentgradingsystemspring.data.crud.student;

import com.atypon.studentgradingsystemspring.model.Student;

import java.util.List;
public interface StudentCrud{

    Integer save(Student student);

    Student findByUsername(String username);

    List<Student> findAll();
}
