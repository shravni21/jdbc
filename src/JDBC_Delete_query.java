
import  java.sql.*;

public class JDBC_Delete_query {
    public static void main(String[] args) throws ClassNotFoundException {
// Delete data
        String url= "jdbc:mysql://localhost:3306/mydatabase";
        String username= "root";
        String password="Smile@123";
        String query="DELETE from employees where id=4; ";
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
                System.out.println("Deleted successfully! "+ rowsAffected+ "row(s) affected.");
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
