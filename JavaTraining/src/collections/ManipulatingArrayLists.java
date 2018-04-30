package collections;

import java.util.ArrayList;
import java.util.ListIterator;

public class ManipulatingArrayLists {
  
  public static void main(String[] args) {
    
    // Creating ArrayList with default initial capacity of 10.
    ArrayList<String> list = new ArrayList<>();
    
    // Adding String objects, duplicate values allowed
    list.add("Alice");
    list.add("Bob");
    list.add("Alice");
    
    // Adds String object "Eve" at first position.
    // Existing elements are move one position ahead.
    list.add(0, "Eve");
    
    // Uses equals() to find and remove first occurrence of value matching String "Eve"
    list.remove("Eve");
    
    // Replaces value at position 0 with new string, returning the replaced value
    String oldValue = list.set(0, "Charlie");
    
    // Return the number of elements in the list.
    list.size();
    
    try {
      // Retrieves element at position 7.
      // Throws IndexOutOfBoundsException if index is >= list.size();
      list.get(7);
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e.getMessage());
    }
    
    
    // contains() searches remaining items in list sequentially 
    // and uses equals() to find first matching occurrence.
    System.out.println("list contains Bob : " + list.contains("Bob"));
    
    // List can return multiple iterators, Iterator and ListIterator.
    ListIterator<String> iterator = list.listIterator();
    // hasNext() returns boolean value indicating whether iterator can access more values
    while (iterator.hasNext()) {
      // next() accesses and returns next value
      System.out.println(iterator.next());
    }
  }
  
}
