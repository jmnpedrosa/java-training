package java_IO_fundamentals;

import java.io.Console;

/*
 * How to work with a system console.
 * Accessing a system usually does not work from inside an IDE,
 * but it should work from a command line / external terminal.
 */

public class UsingSystemConsole {
  
  public static void main(String[] args) {
    
    Console console = System.console(); // Will return 'null' if no console is available.
    
    if (console != null) {
      
      // Show a prompt message and await input.
      String file = console.readLine("Enter File to delete:");
      
      // Multiple ways of printing output
      console.format("About to delete %s %n", file);
      console.printf("Sure to delete %s(Y/N)?", file);
      
      String delete = console.readLine();
      if (delete.toUpperCase().trim().equals("Y")) {
        
        // Show a prompt message and await input.
        // Password is not shown while being typed.
        char[] pwd = console.readPassword("Enter Password:");
        if (pwd.length > 0)
          console.format("Deleted %s", file);
        else
          console.format("No password. Cancelling deletion");
        
      } else {
        console.format("Operation cancelled... %nNow exiting.");
      }
      
    } else {
      System.out.println("No console");
    }
    
  }
}

