package data.crud.studentsCourses;

import model.StudentsCourses;

import java.util.List;

public interface StudentsCoursesCrud {

    List<StudentsCourses> getStudentCourses(String username);

    Double getStudentAverage(String courseName);

    Double getStudentMedian(String courseName);

    Double getStudentMax(String courseName);

    Double getStudentMin(String courseName);
}
