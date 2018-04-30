package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileTime;

/*
 * Example of using a FileAttributeView to access 
 * and modify the file's basic attributes.
 */

public class UsingFileAttributeView {
  
  public static void modifyDateAttr(String fileName) throws IOException {
    Path file = Paths.get(fileName);
    BasicFileAttributeView view = Files.getFileAttributeView(file, BasicFileAttributeView.class);
    
    long now = System.currentTimeMillis();
    FileTime creation = FileTime.fromMillis(now - 60000);
    FileTime lastModified = FileTime.fromMillis(now - 50000);
    FileTime lastAccess = FileTime.fromMillis(now - 30000);
    
    view.setTimes(lastModified, lastAccess, creation);
  }
  
}
