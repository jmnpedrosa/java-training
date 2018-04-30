package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;

/*
 * Example of modifying a file's individual attributes using
 * the static methods Files.getAttribute() and Files.setAttribute()
 */

public class ModifyingFileAttributes {
  
  public static void main(String[] args) throws IOException {
    
    Path path = Paths.get("D:\\myfile.txt");
    System.out.println("creationTime: " + Files.getAttribute(path, "creationTime"));
    
    FileTime newTime = FileTime.fromMillis(System.currentTimeMillis());
    Files.setAttribute(path, "creationTime", newTime);
    
    System.out.println("creationTime: " + Files.getAttribute(path, "creationTime"));
  }
  
}
