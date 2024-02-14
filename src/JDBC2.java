
import  java.sql.*;

public class JDBC2 {
    public static void main(String[] args) throws ClassNotFoundException {
// Insert data
        String url= "jdbc:mysql://localhost:3306/mydatabase";
        String username= "root";
        String password="Smile@123";
        String query="INSERT INTO employees(id,name,job_title,salary)values(7,'Pankaj', 'Finance Manager',50000.0); ";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded successfully!");
        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection established successfully!");
            Statement stmt= con.createStatement();
            int rowsAffected= stmt.executeUpdate(query);
            if(rowsAffected>0){
                System.out.println("Inserted successfully! "+ rowsAffected+ "row(s) affected.");
            }
            else{
                System.out.println("Failed!");
            }
            stmt.close();
            con.close();
            System.out.println("Connection closed successfully!");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
