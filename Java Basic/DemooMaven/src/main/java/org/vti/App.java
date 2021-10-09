package org.vti;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        String dbURL = "jdbc:mysql://Localhost:3306/fresher_training_management";
        String username = "root";
        String password = "12345678";

        //B1
        Connection connection = DriverManager.getConnection(dbURL, username, password);

        //B2
        Statement statement = connection.createStatement();

        //B3
        ResultSet resultSet = statement.executeQuery("SELECT full_name, gender, training_class FROM trainee;");

        //B4
        while (resultSet.next()){
            System.out.printf("|"+ "%20s", resultSet.getString("full_name") + "|" );
            System.out.printf("%20s", resultSet.getString("gender") + "|");
            System.out.println(resultSet.getString("training_class") + "|");
        }
        }
}
