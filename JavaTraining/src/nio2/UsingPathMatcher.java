package nio2;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

/*
 * You can use a PathMatcher to compare Paths 
 * with a given "regex" or "blob" expression.
 */

public class UsingPathMatcher {
  
  public static void main(String[] args) {
    PathMatcher matcher = FileSystems.getDefault().getPathMatcher("regex:[1-9]*[0-9]?-[1-9]?.txt");

    Path file = Paths.get("77-1.txt");
    if (matcher.matches(file)) {
      System.out.println(file);
    }
  }
  
}
