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
 * The following procedure defines a "count" variable
 * that serves as both input and output for the procedure.
 * 
 * See CallingProcedures.java for how to call a procedure.
 */

public class CreatingDBProcedures2 {
  
  public static void main(String[] args) {
    try {
      Connection con = getConnection();
      PreparedStatement statement = con.prepareStatement
          ("CREATE PROCEDURE proc_item_count (OUT count INT) "+
              "BEGIN "+
              "SELECT COUNT(*) INTO count FROM item; "+
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
