package java_IO_fundamentals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadWriteBytesUsingFiles {
  
  public static void main(String[] args) throws FileNotFoundException, IOException {
    
    try (FileInputStream in = new FileInputStream("one_file.txt");
         FileOutputStream out = new FileOutputStream("another_file.txt");) {
      
      int data;
      // Read and write 1 byte at a time
      // while ((data = in.read()) != -1) {
      //  out.write(data);
      // }
      
      // Read and write 1024 bytes at a time
      byte[] byteArr = new byte[1024];
      while ((data = in.read(byteArr)) != -1) {
        out.write(byteArr, 0, data);
      }
      
    }
    
  }
}
