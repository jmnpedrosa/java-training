package collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

/*
 * A TreeSet works fine with String, as this class already defines a natural order.
 */

public class TestTreeSet {
  
  public static void main(String[] args) {
    
    // Duplicate values will be ignored
    String[] myStrings = {"The", "End", "Is", "The", "Beginning"};
    
    // Clever conversion from Array -> List -> TreeSet :)
    TreeSet<String> treeSetStrings = new TreeSet<>(Arrays.asList(myStrings));
    
    // Iterate through the Map in descending order.
    Iterator<String> it = treeSetStrings.descendingIterator();
    while (it.hasNext())
      System.out.println(it.next());
  }
  
}
