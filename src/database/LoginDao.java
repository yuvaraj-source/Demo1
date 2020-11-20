package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.LoginBean;

public class LoginDao {
	
    public int register( LoginBean loginBean) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO users" +"  (username, email, password) VALUES " +" (?, ?, ?);";
        int result= 0;
        Class.forName("com.mysql.jdbc.Driver");
        
        try (Connection connection = DriverManager.getConnection(
        										   "jdbc:mysql://localhost:3306/signup_db?useSSL=false", "root", "sanjay");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
      
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getEmail());
            preparedStatement.setString(3, loginBean.getPassword());
           
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
           
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return result;
    }
}



