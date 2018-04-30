package java_IO_fundamentals;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Run this code and compare the I/O time with file
 * UsingNonBufferedStreams.java to understand the importance of buffering ;)
 */

public class UsingBufferedStreams {
  
  public static void main(String[] args) throws IOException {
    
    try (FileInputStream in = new FileInputStream("D:\\myfile.txt");
         FileOutputStream out = new FileOutputStream("D:\\myfile_copy_buffered.txt");
         BufferedInputStream bis = new BufferedInputStream(in);
         BufferedOutputStream bos = new BufferedOutputStream(out);) {
      
      long start = System.currentTimeMillis();
      
      // Read byte by byte from input file and write to output file
      int data;
      while ((data = bis.read()) != -1) {
        bos.write(data);
      }
      
      long end = System.currentTimeMillis();
      System.out.println("MilliSeconds elapsed : " + (end-start));
    }
    
  }
}
