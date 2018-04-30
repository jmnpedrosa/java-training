package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * You can map the output of a PreparedStatement into the input
 * of a new PreparedStatement.
 */

public class UsingCombinedPreparedStatements {
  
  public static void main(String[] args) {
    try {
      Connection con = getConnection();
      PreparedStatement bookUpdStmt = con.prepareStatement("UPDATE item SET description = ? WHERE id = ?");
      PreparedStatement bookNewPrStmt = con.prepareStatement("SELECT id, description FROM new_item");
      
      ResultSet bookNewPrRs = bookNewPrStmt.executeQuery();
      
      while (bookNewPrRs.next()) {
        bookUpdStmt.setDouble(1, bookNewPrRs.getDouble("description"));
        bookUpdStmt.setString(2, bookNewPrRs.getString("id"));
        bookUpdStmt.executeUpdate();
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
