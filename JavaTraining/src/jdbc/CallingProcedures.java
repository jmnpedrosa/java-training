package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * You can call stored DB procedures by calling prepareCall() from a Connection
 * to retrieve a CallableStatement. Then you call executeQuery() on it.
 * 
 * See CreatingDBProcedures.java for how to create a procedure.
 */

public class CallingProcedures {
  
  public static void main(String[] args) {
    try {
      Connection con = getConnection();
      CallableStatement cs = con.prepareCall("{call item_details_last_modified()}");
      ResultSet rs = cs.executeQuery();
      while(rs.next()) {
        System.out.println(rs.getString("id") + "--" +
            rs.getString("description") + "--" +
            rs.getDouble("last_modified"));
      }
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
