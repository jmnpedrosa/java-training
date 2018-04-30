package jdbc;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

/*
 * With a JdbcRowSet you can use a single object to connect to a database, create
 * a statement, execute a query and return its results
 */

public class UsingRowSet {
  
  public static void main(String[] args) {
    
    JdbcRowSet jdbcRS = null;
    try {
      // Get a RowSetFactory via a default provider
      RowSetFactory rowSetFactory = RowSetProvider.newFactory();
      // Get a JdbcRowSet from the factory.
      jdbcRS = rowSetFactory.createJdbcRowSet();

      jdbcRS.setUrl("jdbc:mysql://localhost/examplebd");
      jdbcRS.setUsername("test");
      jdbcRS.setPassword("test");
      jdbcRS.setCommand("SELECT * FROM item");
      jdbcRS.execute();

      // The cursor starts before the first row.
      while (jdbcRS.next()) { // gets the next row and returns whether there are more.
        System.out.print(jdbcRS.getString("id") + "-");
        System.out.print(jdbcRS.getString("description") +"-");
        System.out.print(jdbcRS.getString("is_relevant"));
        System.out.println();
      }
      
    } catch (SQLException e) {
      System.out.println(e);
      
    } finally {
      try {
        jdbcRS.close();
      }
      catch (SQLException e) {}
    }
  }
}
