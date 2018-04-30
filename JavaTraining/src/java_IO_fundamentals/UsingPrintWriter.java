package java_IO_fundamentals;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class UsingPrintWriter {
  
  public static void main(String[] args) {
    
    try {
      // Open a writer to a file, appending to existing content.
      FileWriter fw = new FileWriter("D:\\myfile.txt", true);
      PrintWriter pw = new PrintWriter(fw);
      
      pw.write(97);
      pw.write("String");
      pw.write("PartialString", 0, 4);
      pw.write(new char[]{'c','h','a','r'});
      pw.write(new char[]{'c','h','a','r'}, 1, 1);
      
      pw.print(true);
      pw.print('a');
      pw.print(12.45f);
      pw.print(41.87);
      pw.print(39865L);
      pw.print(pw);
      pw.print(new Integer(10));
      
      pw.println(true);
      pw.println('a');
      pw.println(12.45f);
      pw.println(41.87);
      pw.println(39865L);
      pw.println(pw);
      pw.println(new Integer(10));
      
      pw.close();
      
    } catch (IOException ioe) {
      System.out.println(ioe);
    }
    
  }
  
}
