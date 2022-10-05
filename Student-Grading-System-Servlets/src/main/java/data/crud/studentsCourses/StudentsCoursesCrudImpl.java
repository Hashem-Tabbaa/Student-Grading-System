package data.crud.studentsCourses;

import data.DBConnection;
import model.StudentsCourses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class StudentsCoursesCrudImpl implements StudentsCoursesCrud {

    private final String TABLE_NAME = "students_courses";

    @Override
    public List<StudentsCourses> getStudentCourses(String username) {
        List<StudentsCourses> students_course = new Vector<>();
        try{
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE student_username = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                students_course.add(new StudentsCourses(
                        resultSet.getString("student_username"),
                        resultSet.getString("course_name"),
                        resultSet.getInt("mark")
                ));
            }
            return students_course;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                DBConnection.getConnection().close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return Collections.emptyList();
    }

    @Override
    public Double getStudentAverage(String courseName) {
        try{
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT AVG(mark) FROM " + TABLE_NAME + " WHERE course_name = ?");
            statement.setString(1, courseName);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
                return resultSet.getDouble(1);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                DBConnection.getConnection().close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Double getStudentMedian(String courseName) {
        List<Double> marks = new Vector<Double>();
        try{
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT mark FROM "
                    + TABLE_NAME + " WHERE course_name = ? ORDER BY mark");
            statement.setString(1, courseName);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                marks.add(resultSet.getDouble("mark"));
            }
            if(marks.isEmpty())
                return null;
            if(marks.size() % 2 == 0)
                return (marks.get(marks.size() / 2) + marks.get(marks.size() / 2 - 1)) / 2;
            else
                return marks.get(marks.size() / 2);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                DBConnection.getConnection().close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Double getStudentMax(String courseName) {
        try{
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT MAX(mark) FROM " + TABLE_NAME + " WHERE course_name = ?");
            statement.setString(1, courseName);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
                return resultSet.getDouble(1);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                DBConnection.getConnection().close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Double getStudentMin(String courseName) {
        try{
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT MIN(mark) FROM " + TABLE_NAME + " WHERE course_name = ?");
            statement.setString(1, courseName);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next())
                return resultSet.getDouble(1);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                DBConnection.getConnection().close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
