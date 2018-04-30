package nio2;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/*
 * Examples of how Path objects can be read and manipulated.
 */

public class UsingPaths {
  
  public static void main(String args[]) throws IOException {
    
    // Extracting information about the path's components
    Path path = FileSystems.getDefault().getPath("D:\\files\\myfile.txt");
    System.out.println("toString()-> " + path.toString());
    System.out.println("getRoot()-> " + path.getRoot());
    System.out.println("getName(0)-> " + path.getName(0));
    System.out.println("getName(1)-> " + path.getName(1));
    System.out.println("getFileName()-> " + path.getFileName());
    System.out.println("getNameCount()-> " + path.getNameCount());
    System.out.println("getParent()-> " + path.getParent());
    System.out.println("subpath(0,2)-> " + path.subpath(0,2));
    
    System.out.println();
    
    path = Paths.get("/somedir/stuff");
    System.out.println(path.resolve(Paths.get("world/Hello.java")));
    System.out.println(path.resolve("/world/Hello.java"));
    
    System.out.println();
    
    // Resolving a relative path against an absolute path and vice-versa
    Path absolutePath = Paths.get("C:/folder/");
    System.out.println(absolutePath.resolve(path));
    System.out.println(path.resolve(absolutePath));
    
    System.out.println();
    
    // Resolving a path against this path's parent
    path = Paths.get("/src/FancyClass.java");
    Path renamePath = path.resolveSibling(Paths.get("CrazyClass.java"));
    Path copyPath = path.resolveSibling("backup/LazyClass.java");
    absolutePath = Paths.get("D:/code/");
    System.out.println(renamePath);
    System.out.println(copyPath);
    System.out.println(path.resolveSibling(""));
    System.out.println(absolutePath.resolveSibling(path));
    System.out.println(path.resolveSibling(absolutePath));
    
    System.out.println();
    
    Path source = Paths.get("notes.txt");
    Files.move(source, source.resolveSibling("copy-notes.txt"));
    
    System.out.println();
    
    // Moving a file from one path to another
    source = Paths.get("notes.txt");
    Path target = Paths.get("/home/notes/");
    Files.move(source, target.resolve(source.getFileName()), StandardCopyOption.REPLACE_EXISTING);
    
  }
}