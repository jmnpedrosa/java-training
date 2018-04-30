package nio2;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

/*
 * Examples of methods from the Path class used for Path object comparisons. 
 * Many of these are similar to String comparisons.
 */

public class ComparingPaths {
  
  public static void main(String[] args) {
    
    // Both these lines are equivalent
    Path path1 = FileSystems.getDefault().getPath("c:\\users\\myuser\\myfile.txt");
    Path path2 = Paths.get("c:\\users\\myuser\\myfile.txt");
    
    // Compare lexicographically
    System.out.println(path1.compareTo(path2));
    System.out.println(path2.startsWith("\\"));
    
    System.out.println(path1.endsWith("-1.txt"));
    System.out.println(path1.endsWith(Paths.get("8-1.txt\\")));
    
    path1 = Paths.get("MyDir/hello.java");
    path2 = Paths.get("FriendDir/code");
    
    // Get relative path between path1 and path2
    Path path3 = path1.relativize(path2);
    
    // You can iterate over each sub-path in a path
    for (Path path : path3)
      System.out.println(path);
    
    Path path_a = Paths.get("/mydir/notes/java/String");
    Path path_b = Paths.get("/mydir/notes/java");
    
    // Path matcher finds paths that match a given 'glob' pattern
    PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:/mydir/*/*");
    System.out.println(matcher.matches(path_a));
    System.out.println(matcher.matches(path_b));
  }
  
}
