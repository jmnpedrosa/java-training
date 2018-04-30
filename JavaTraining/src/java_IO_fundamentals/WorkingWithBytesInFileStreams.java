package java_IO_fundamentals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/*
 * FileInputStream and FileOutputStream work directly with bytes
 * and FileOutputStream will actually return a byte as an int variable.
 */

public class WorkingWithBytesInFileStreams {
  
  public static void main(String[] args) throws Exception {
    
    try (OutputStream os = new FileOutputStream("temp.txt");
         InputStream is = new FileInputStream("temp.txt");) {
      
      int i999 = 0b00000000_00000000_00000011_11100111;
      int i20 = 0b00000000_00000000_00000000_00010100;
      os.write(i999);
      os.write(i20);
      System.out.println(i999 + ":" + is.read());
      System.out.println(i20 + ":" + is.read());
      
    }
    
  }
  
}
