package model;

import java.io.Serializable;

public class StudentsCourses implements Serializable {

    private String course_name;
    private String student_username;
    private Double mark;

    public StudentsCourses(String username, String course_id, int mark) {
        this.student_username = username;
        this.course_name = course_id;
        this.mark = (double) mark;
    }

    @Override
    public String toString() {
        return "Course name : '" + course_name + '\'' +
                "    Your mark = " + mark ;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getStudent_username() {
        return student_username;
    }

    public void setStudent_username(String student_username) {
        this.student_username = student_username;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }
}
