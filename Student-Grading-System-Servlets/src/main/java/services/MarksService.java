package services;

import data.crud.studentsCourses.StudentsCoursesCrud;
import model.Statistics;
import model.StudentsCourses;

import java.util.List;
import java.util.Vector;

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

    public List<Statistics> getStatistics(String courseName){
        List<Statistics> statistics = new Vector<>();
        statistics.add(new Statistics("Average", getStudentAverage(courseName)));
        statistics.add(new Statistics("Median", getStudentMedian(courseName)));
        statistics.add(new Statistics("Max", getStudentMax(courseName)));
        statistics.add(new Statistics("Min", getStudentMin(courseName)));
        return statistics;
    }

}
