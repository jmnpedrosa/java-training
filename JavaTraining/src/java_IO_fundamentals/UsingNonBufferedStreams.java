package java_IO_fundamentals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Run this code and compare the I/O time with file
 * UsingBufferedStreams.java to understand the importance of buffering ;)
 */

public class UsingNonBufferedStreams {
  
  public static void main(String[] args) throws IOException {
    
    try (FileInputStream in = new FileInputStream("D:\\myfile.txt");
         FileOutputStream out = new FileOutputStream("D:\\myfile_copy_buffered.txt");) {
      
      long start = System.currentTimeMillis();
      
      // Read byte by byte from input file and write to output file
      int data;
      while ((data = in.read()) != -1) {
        out.write(data);
      }
      
      long end = System.currentTimeMillis();
      System.out.println("MilliSeconds elapsed : " + (end-start));
    }
    
  }
}
