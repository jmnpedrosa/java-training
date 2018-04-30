package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * If the table you query has no data, it will still return an initialized
 * ResultSet object, but it will not contain any rows.
 */

public class QueryingTableWithNoData {
  
  public static void main(String[] args) {
    try (Connection con = getConnection();
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("SELECT id, value, creation_user FROM item WHERE is_relevant = true");){
      
      System.out.println(rs);
      
      // The ResultSet is not null, and you can extract its column names
      ResultSetMetaData rsmd = rs.getMetaData();
      System.out.println(rsmd.getColumnLabel(1));
      System.out.println(rsmd.getColumnLabel(2));
      System.out.println(rsmd.getColumnLabel(3));
    }
    catch (SQLException e) {
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
