package nio2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

/*
 * The method Files.newDirectoryStream() returns a convenient iterable object
 * with all the entries in a given directory (as Paths)
 */

public class UsingDirectoryStream {
  
  public static void main(String[] args) throws IOException {
    
    Path dir = Paths.get("C:\\somedir");
    
    try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
      Iterator<Path> iterator = stream.iterator();
      while (iterator.hasNext()) {
        System.out.println(iterator.next());
      }
    }
    
  }
}
