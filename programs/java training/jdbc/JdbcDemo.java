package jdbc;
import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) {

        try {

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/campus",
                "root",
                "Gunal@15"
            );

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(
                "SELECT * FROM users;"
            );

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("name")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}