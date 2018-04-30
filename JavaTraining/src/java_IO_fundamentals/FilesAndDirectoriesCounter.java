package java_IO_fundamentals;

import java.io.File;

/*
 * Class that demonstrates how to traverse a directory and check if
 * its contents are files or sub-directories.
 */

public class FilesAndDirectoriesCounter {
  
  public static void main(String... args) {
    countDirFiles(new File("c:\\temp"));
  }

  public static void countDirFiles(File dir) {
    if (dir.isDirectory()) {
      
      int fileCount = 0;
      int dirCount = 0;
      String[] list = dir.list();
      File item = null;
      
      for (String listItem : list) {
        
        item = new File(dir, listItem);
        if (item.isFile())
          ++fileCount;
        else if (item.isDirectory())
          ++dirCount;
      }
      
      System.out.println ("File(s): " + fileCount);
      System.out.println ("Directories(s): " + dirCount);
      
    } else {
      throw new IllegalArgumentException("Not a directory");
    }
  }
}

