package nio2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * To traverse a file tree using Files.walkFileTree(), you can create a class
 * that implements the FileVisitor<? super Path> interface.
 * 
 * You must specify some kind of behavior for every defined method of the FileVisitor
 * interface and return a FileVisitResult enum value.
 */

public class MyFileVisitor implements FileVisitor<Path> {
  
  Map<String, java.util.List<String>> flashcards = new HashMap<>();

  @Override
  public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
    String dirName = dir.getFileName().toString();
    if (dirName.startsWith("code")) 
      return FileVisitResult.SKIP_SUBTREE;
    else
      return FileVisitResult.CONTINUE;
  }
  
  @Override
  public FileVisitResult postVisitDirectory(Path dir, IOException attrs) throws IOException {
    return FileVisitResult.CONTINUE;
  }


  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
    String fileName = file.getFileName().toString();
    
    if (fileName.endsWith(".txt")) {
      java.util.List<String> tips = new ArrayList<>();
      
      try (BufferedReader reader = new BufferedReader(new FileReader(file.toFile()))) {
        String line = null;
        while ((line = reader.readLine()) != null)
          tips.add(line);
        
      } catch (Exception e) {
        System.out.println(e);
      }
      
      flashcards.put(fileName.substring(0, fileName.length() - 4), tips);
    }
    return FileVisitResult.CONTINUE;
  }

  @Override
  public FileVisitResult visitFileFailed(Path dir, IOException exc) throws IOException {
    System.out.println(exc);
    return FileVisitResult.SKIP_SUBTREE;
  }
  
  public Map<String, java.util.List<String>> getFlashCardsMap() {
    return flashcards;
  }

}
