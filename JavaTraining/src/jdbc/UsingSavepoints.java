package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

/*
 * To make a transaction, you must disable auto-commit in you Connection.
 * You can the define multiple Savepoints to rollback the transaction into.
 */

public class UsingSavepoints {
  
  public static void main(String[] args) {
    
    Connection con = null;
    Statement statement = null;
    try {
      con = getConnection();
      
      // Connection auto-commit must be set to false to begin transaction
      con.setAutoCommit(false);
      statement = con.createStatement();

      int result = statement.executeUpdate
          ("INSERT INTO transaction values " +
              " (101, '5555', 'db', 2099.0, '2020-10-01')");
      result = statement.executeUpdate
          ("UPDATE bank_account " +
              "SET balance = balance + 2099.0 " +
              "WHERE acct_no='5555'");

      Savepoint sp5555 = con.setSavepoint();

      result = statement.executeUpdate
          ("INSERT INTO transaction values " +
              " (102, '7777', 'db', 12099.0, '2020-10-01')");

      result = statement.executeUpdate
          ("UPDATE bank_account " +
              "SET balance = balance + 12099.0 " +
              "WHERE acct_no='7777'");

      Savepoint sp7777 = con.setSavepoint("CrSalaryFor7777");

      result = statement.executeUpdate
          ("INSERT INTO transaction values " +
              " (103, '9999', 'db', 5099.0, '2020-10-01')");

      result = statement.executeUpdate
          ("UPDATE bank_account " +
              "SET balance = balance + 5099.0 " +
              "WHERE acct_no='9999'");

      Savepoint savepoint = con.setSavepoint("CrSalaryFor9999");

      con.rollback(sp7777); // undo everything after savepoint "sp7777"
      con.commit(); // Manually commit the transaction.
      
    } catch (SQLException e) {
      System.out.println(e);
      try {
        con.rollback();
      } catch(SQLException ex) {
        System.out.println(ex);
      }
    }
  }
  
  static Connection getConnection() throws SQLException {
    String url = "jdbc:mysql://localhost/examplebd";
    String username = "test";
    String password = "test";
    return DriverManager.getConnection(url, username, password);
  }
}
