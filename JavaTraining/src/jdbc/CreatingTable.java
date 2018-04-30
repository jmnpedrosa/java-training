package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To create a new table in a DB, create a Statement and call
 * executeUpdate() with the CREATE TABLE syntax from SQL,
 * as shown below.
 */

public class CreatingTable {
  
  public static void main(String[] args) {
    Connection con = null;
    Statement statement = null;
    try {
      String url = "jdbc:mysql://localhost/examplebd";
      String username = "test";
      String password = "test";
      
      con = DriverManager.getConnection(url, username, password);
      
      statement = con.createStatement();
      
      int result = statement.executeUpdate("CREATE TABLE item " +
          " (id INT PRIMARY KEY, " +
          " description VARCHAR(1000), " +
          " creation_user CHAR(255), " +
          " is_relevant BOOLEAN, " +
          " last_modified TIMESTAMP)");
      System.out.println(result);
      
    } catch (SQLException e) {
      System.out.println(e);
    }
    System.out.println(con);
  }
}
