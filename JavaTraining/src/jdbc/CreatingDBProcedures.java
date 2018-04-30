package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * You can create procedures in DB to be called later.
 * Just execute a PreparedStatement with the CREATE PROCEDURE
 * SQL syntax as shown below.
 * 
 * See CallingProcedures.java for how to call a procedure.
 */

public class CreatingDBProcedures {
  public static void main(String[] args) {
    try {
      Connection con = getConnection();
      PreparedStatement statement = con.prepareStatement
          ("CREATE PROCEDURE item_details_last_modified() "+
              "BEGIN "+
              "SELECT A.id, A.description, B.last_modified " +
              "FROM items A, last_modifications B " +
              "WHERE A.id = B.id; "+
              "END;");
      int result = statement.executeUpdate();
      System.out.println(result);
      
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
