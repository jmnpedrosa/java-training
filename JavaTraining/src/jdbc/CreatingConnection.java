package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreatingConnection {
  
  public static void main(String[] args) {
    
    Connection con = null;
    
    try {
      String url = "jdbc:mysql://localhost/examplebd";
      String username = "test";
      String password = "test";
      
      con = DriverManager.getConnection(url, username, password);
      
    } catch (SQLException e) {
      System.out.println(e);
    }
    
    System.out.println(con);
  }
}
