package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To delete data from a table, create a Statement and call executeUpdate(),
 * using the DELETE syntax from SQL as shown below.
 */

public class DeletingFromTable {
  
  public static void main(String[] args) {
    try (Connection con = getConnection();
        Statement statement = con.createStatement()) {
      
      int result = statement.executeUpdate
          ("DELETE FROM item WHERE is_relevant = false");
      System.out.println(result);
    }
    catch (SQLException e) {
      System.out.println(e);
    }
  }
  
  static Connection getConnection() throws SQLException{
    String url = "jdbc:mysql://localhost/examplebd";
    String username = "test";
    String password = "test";
    return DriverManager.getConnection(url, username, password);
  }
}
