package server.data.crud.student;

import server.data.DBConnection;
import server.data.crud.student.StudentCrud;
import server.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

public class StudentCrudImpl implements StudentCrud{

    private final String TABLE_NAME = "student";
    private Connection connection;

    public StudentCrudImpl() {
        try{
            connection = DBConnection.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Integer save(Student student) {
        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO " + TABLE_NAME +
                    " (firstName , lastName , username , password) VALUES (?,?,?,?)");
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            statement.setString(3, student.getUsername());
            statement.setString(4, student.getPassword());

            return statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student findByUsername(String username) {
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE username = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next() ? new Student(
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getString("username"),
                    resultSet.getString("password")
            ) : null;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + TABLE_NAME);
            List<Student> students = new Vector<Student>();
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                students.add(new Student(firstName, lastName, username, password));
            }
            return students;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
