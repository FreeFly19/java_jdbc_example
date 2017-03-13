import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://127.0.0.1/java_course");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        //INSERT/UPDATE/DELETE
        int affectedRowCount = statement.executeUpdate("");
        //SELECT
        ResultSet rs = statement.executeQuery("select * from students");
        //OTHERS
        boolean success = statement.execute("");


        while(rs.next()) {
            System.out.println(rs.getString("name"));
        }
        connection.close();

    }
}
