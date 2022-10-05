package com.atypon.studentgradingsystemspring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentsCourses implements Serializable {

    private String course_name;
    private String student_username;
    private Double mark;


    public StudentsCourses() {

    }
}
