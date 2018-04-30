package nio2;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/*
 * To traverse a file tree using Files.walkFileTree(), you can create a class
 * that extends SimpleFileVisitor<T>.
 * 
 * You can choose to override each defined method of SimpleFileVisitor
 * and must return a FileVisitResult enum value.
 */

class ListFileNames extends SimpleFileVisitor<Path> {
  
  // Override only the visitFile() method.
  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {
    System.out.println("File name: " + file.getFileName());
    return FileVisitResult.CONTINUE;
  }
  
}

public class UsingSimpleFileVisitor {
  public static void main(String[] args) throws IOException {
    Path path = Paths.get("D:\\mydir");
    ListFileNames listFileNames = new ListFileNames();
    Files.walkFileTree(path, listFileNames);
  }
}
