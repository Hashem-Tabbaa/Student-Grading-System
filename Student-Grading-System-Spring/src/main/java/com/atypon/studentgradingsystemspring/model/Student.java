package com.atypon.studentgradingsystemspring.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {

    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public Student() {

    }
}
