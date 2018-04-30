package java_IO_fundamentals;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadingChars {
  
  public static void main(String[] args) throws IOException {
    
    try (FileReader input = new FileReader("D:\\myfile.txt");
         FileWriter output = new FileWriter("D:\\myfile_copy.txt");) {
      
      // Char values are read in their "int" representation
      int data;
      while ((data = input.read()) != -1) {
        output.write(data);
      }
    }
  }
  
}
