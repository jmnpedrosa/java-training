package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To update a table data, create a Statement and call
 * executeUpdate() with the UPDATE syntax from SQL,
 * as shown below.
 */

public class UpdatingTable {
  
  public static void main(String[] args) {
    
    try (Connection con = getConnection();
        Statement statement = con.createStatement()){
      
      int ret = statement.executeUpdate
          ("UPDATE item " +
              "SET is_relevant = true " +
              "WHERE creation_user = 'jmnpedrosa'");
      System.out.println(ret);
      
    } catch (SQLException e) {
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
