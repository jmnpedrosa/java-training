package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Example of how a PreparedStatement is called.
 * Unlike a Statement, the query string is passed to the preparedStatement()
 * method, instead of the executeQuery().
 */

public class QueryingWithPreparedStatement {
  
  public static void main(String[] args) {
    try (Connection con = getConnection();
         PreparedStatement stmt = con.prepareStatement("SELECT * FROM item WHERE is_relevant = true");
         ResultSet rs = stmt.executeQuery();) {

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
