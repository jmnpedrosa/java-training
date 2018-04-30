package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To insert data into a table, create a Statement and call
 * executeUpdate() with the INSERT INTO syntax from SQL,
 * as shown below.
 */

public class InsertingIntoTable {
  
  public static void main(String[] args) {
    try (Connection con = getConnection();
         Statement statement = con.createStatement()) {
      int ret = statement.executeUpdate
          ("INSERT INTO item VALUES (" +
          "1, 'This is my very important item', 'jmnpedrosa', false, '2038-01-19 03:14:07')");
      System.out.println(ret);
    } catch (SQLException e) {
      System.out.println(e);
    }
  }
  
  static Connection getConnection() throws SQLException {
    String url = "jdbc:mysql://localhost/examplebd";
    java.util.Properties prop = new java.util.Properties();
    prop.put("user", "test");
    prop.put("password", "test");
    return DriverManager.getConnection(url, prop);
  }
}
