package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * Path has a series of utility methods that allow you to read
 * its attributes, as shown below.
 */

public class AcessingPathAtrributes {

  public static void main(String[] args) throws IOException {
    
    Path path = Paths.get("D:\\myfile.txt");
    
    System.out.println("size:" + Files.size(path));
    System.out.println("isDirectory:" + Files.isDirectory(path));
    System.out.println("isExecutable:" + Files.isExecutable(path));
    System.out.println("isHidden:" + Files.isHidden(path));
    System.out.println("isReadable:" + Files.isReadable(path));
    System.out.println("isSameFile:" + Files.isSameFile(path, path));
    System.out.println("isDirectory:" + Files.isDirectory(path));
    System.out.println("isSymbolicLink:" + Files.isSymbolicLink(path));
    System.out.println("isWritable:" + Files.isWritable(path));
    System.out.println("getLastModifiedTime:" + Files.getLastModifiedTime(path));
    
    System.out.println("getOwner:" + Files.getOwner(path));
    
  }
  
}
