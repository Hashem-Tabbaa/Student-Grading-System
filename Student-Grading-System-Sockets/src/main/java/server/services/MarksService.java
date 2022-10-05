package server.services;

import server.data.DBConnection;
import server.data.crud.studentsCourses.StudentsCoursesCrud;
import server.data.crud.studentsCourses.StudentsCoursesCrudImpl;
import server.model.StudentsCourses;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MarksService {

    private final StudentsCoursesCrud studentsCoursesCrud;

    public MarksService(StudentsCoursesCrud studentsCoursesCrud){
        this.studentsCoursesCrud = studentsCoursesCrud;
    }

    public List<StudentsCourses> getStudentCourses(String username){
        return studentsCoursesCrud.getStudentCourses(username);
    }

    public Double getStudentAverage(String courseName){
        return studentsCoursesCrud.getStudentAverage(courseName);
    }

    public Double getStudentMedian(String courseName){
        return studentsCoursesCrud.getStudentMedian(courseName);
    }

    public Double getStudentMax(String courseName){
        return studentsCoursesCrud.getStudentMax(courseName);
    }

    public Double getStudentMin(String courseName){
        return studentsCoursesCrud.getStudentMin(courseName);
    }



}
