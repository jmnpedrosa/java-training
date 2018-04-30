package java_IO_fundamentals;

import java.io.File;
import java.io.IOException;

/*
 * You can use mkdirs() to physically crate a directory tree from a File object,
 * and createNewFile() to create a file from a File object.
 */

public class CreatingFilesAndDirectories {
  
  public static void main(String... args) throws IOException {
    
    File dirs = new File("\\usr\\code\\java");
    System.out.println(dirs.mkdirs());
    File file = new File(dirs, "myfile.txt");
    if (!file.exists())
      System.out.println(file.createNewFile());
    
  }
  
}
