
import  java.sql.*;

public class JDBC1 {
    public static void main(String[] args) throws ClassNotFoundException {

        String url= "jdbc:mysql://localhost:3306/mydatabase";
        String username= "root";
        String password="Smile@123";
        String query="Select * from employees;";

        try {
            //Step 1: Use Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers loaded successfully!");
        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            //Step 2: Connection establishment
            System.out.println("Connection established successfully!");
            //Step3: Create Statement
            Statement stmt= con.createStatement();
            // Step4: Execute query
            ResultSet re= stmt.executeQuery(query);
            while(re.next()){
                int id= re.getInt("id");
                String name= re.getString("name");
                String job_title= re.getString("job_title");
                double salary= re.getDouble("salary");
                System.out.println("==============================");
                System.out.println("ID: "+id);
                System.out.println("Name: "+name);
                System.out.println("Job Title: "+job_title );
                System.out.println("Salary: "+ salary);
            }
            re.close();
            stmt.close();
            con.close();
            System.out.println("Connection closed successfully!");
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
