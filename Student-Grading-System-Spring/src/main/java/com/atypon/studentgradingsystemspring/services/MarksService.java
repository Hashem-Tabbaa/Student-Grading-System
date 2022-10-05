package com.atypon.studentgradingsystemspring.services;

import com.atypon.studentgradingsystemspring.data.crud.studentsCourses.StudentsCoursesCrud;
import com.atypon.studentgradingsystemspring.model.Statistics;
import com.atypon.studentgradingsystemspring.model.StudentsCourses;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Vector;

@Service
@AllArgsConstructor
public class MarksService {

    private final StudentsCoursesCrud studentsCoursesCrud;

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

        for(Statistics statistic : statistics){
            System.out.println(statistic);
        }

        return statistics;
    }

}
