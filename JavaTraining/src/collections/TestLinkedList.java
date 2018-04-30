package collections;

import java.util.Iterator;
import java.util.LinkedList;

/* 
 * A LinkedList stores its values with pointers to the first and last value.
 * Each stored value also includes pointers to the previous and next linked values.
 */

public class TestLinkedList {
  
  public static void main(String[] args) {
    
    // Creates empty LinkedList of String objects
    LinkedList<String> list = new LinkedList<>();
    
    // Use offer() to add String to end.
    list.offer("Tras");
    // Use push() to add String to beginning.
    list.push("-os-");
    // Use add() to insert at position 1, adjusting position for adjacent values.
    list.add(1, "Montes");
    
    // Finds and removes first matching occurrence for String object.
    System.out.println(list.remove("-os-"));
    
    // Iterates from first element to last
    Iterator<String> it = list.iterator();
    while (it.hasNext()) System.out.println(it.next());
  }  
  
}
