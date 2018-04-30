package nio2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * It is possible to copy files directly into a FileOutputStream
 * using the Files.copy() method, as shown below.
 */

public class WritingDataFromPathToStream {
  
  public static void main(String[] args) {
    
    try (OutputStream out = new FileOutputStream("Copy.txt")) {
      Path source = Paths.get("WritingDataFromPathToStream.java");
      Files.copy(source, out);
    } catch (IOException e) {
      System.out.println(e);
    }
    
  }
  
}
