
import  java.sql.*;

public class JDBC_Updation {
    public static void main(String[] args) throws ClassNotFoundException {
// Update Data
        String url= "jdbc:mysql://localhost:3306/mydatabase";
        String username= "root";
        String password="Smile@123";
        String query="UPDATE employees SET job_title= 'ML Engineer' WHERE id=3";
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
                System.out.println("Updated successfully! "+ rowsAffected+ "row(s) affected.");
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
