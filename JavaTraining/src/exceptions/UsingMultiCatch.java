package exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * A Multi-catch block is useful for when you wish two catch
 * a group of specific, but unrelated exceptions that share
 * the same error control.
 * 
 * Remember that the exceptions included in the multi-catch
 * block must not have any IS-A relationship between each other.
 */

public class UsingMultiCatch {
  
	void example(Connection con, String fileName) {
	  
		try {
			File file = new File(fileName);
			
			// A FileNotFoundException can be thrown.
			FileInputStream fin = new FileInputStream(file);
			
			// An SQLException can be thrown.
			Statement stmt = con.createStatement();
			
		} catch (FileNotFoundException | SQLException e) {
			System.out.println(e.toString());
		} finally {
			System.out.println("finally");
		}
		
	}
}
