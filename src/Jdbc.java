
import  java.util.*;
import  java.sql.*;
public class Jdbc {
    public static void main(String[] args) {
String url= "jdbc:mysql://localhost:3306/students";
  String username= "root";
  String password= "Smile@123";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database!");
            System.out.println(connection);
        } catch (SQLException e) {
            System.out.println("Connection Failed: "+ e.getMessage());
        }
    }
}
