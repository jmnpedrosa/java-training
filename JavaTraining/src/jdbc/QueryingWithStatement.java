package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Example of how a simple Statement is called.
 * Compare this with how a PreparedStatement is executed in QueryingWithPreparedStatement.java
 */

public class QueryingWithStatement {
  
  public static void main(String[] args) {
    try (Connection con = getConnection();
         Statement statement = con.createStatement();
         ResultSet rs = statement.executeQuery("SELECT * FROM item WHERE is_relevant = true");) {
      
      while (rs.next()) {
        System.out.print(rs.getString("id") + "-");
        System.out.print(rs.getString("description") +"-");
        System.out.print(rs.getString("creation_user") + "-");
        System.out.print(rs.getString("is_relevant") + "-");
        System.out.print(rs.getString("last_modified"));
        System.out.println();
      }
    } catch (SQLException e) {
      System.out.println(e);
    }
  }
  
  static Connection getConnection() throws SQLException {
    String url = "jdbc:mysql://localhost/examplebd";
    String username = "test";
    String password = "test";
    return DriverManager.getConnection(url, username, password);
  }
}
