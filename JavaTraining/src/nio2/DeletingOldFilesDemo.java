package nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class DeletingOldFilesDemo {
  
 /*
  * An Example of a method that reads the attributes of a file
  * and deletes that file if its creation time is older than a day.
  */
  
 public static void deleteDayOldFile(String filename) throws IOException {
   Path file = Paths.get(filename);
   
   // Return a read-only list of this file's basic attributes.
   BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
   FileTime fileCreationTime = attr.creationTime();
   
   long currentTime = System.currentTimeMillis();
   FileTime dayOldFileTime = FileTime.fromMillis(currentTime - (24 * 60 * 60 * 1000));
   
   if (fileCreationTime.compareTo(dayOldFileTime) < 0)
     Files.delete(file);
 }
 
}
