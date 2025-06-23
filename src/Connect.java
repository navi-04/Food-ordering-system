

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Connect {
    
    private static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);

        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineFoodOrderDB", "root", "root");
            Statement stmt = con.createStatement();

            // Prepare SQL query
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO customer VALUES(?,?,?,?,?)");

            // Read input from the user
            System.out.println("enter id");
            int cID = in.nextInt();
            in.nextLine(); // Consume the newline left by nextInt

            System.out.println("enter name");
            String name = in.nextLine();

            System.out.println("enter email");
            String email = in.nextLine();

            System.out.println("enter password");
            String password = in.nextLine();

            System.out.println("enter address");
            String address = in.nextLine();

            // Set the values in the prepared statement
            pstmt.setInt(1, cID);
            pstmt.setString(2, name);
            pstmt.setString(3, email);
            pstmt.setString(4, password);
            pstmt.setString(5, address);

            // Execute the insert statement
            pstmt.executeUpdate();

            // Close the connection
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
