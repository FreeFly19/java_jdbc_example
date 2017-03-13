import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://127.0.0.1/java_course");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("select * from students");

        ArrayList<Student> students = new ArrayList<Student>();
        while(rs.next()) {
            Student student = new Student();
            student.name = rs.getString("name");
            student.id = rs.getInt("id");
            student.age = rs.getInt("age");
            students.add(student);
        }
        connection.close();

    }
}
