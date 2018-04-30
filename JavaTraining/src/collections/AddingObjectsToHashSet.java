package collections;

import java.util.HashSet;

/*
 * For a class to be used in a HashMap (or any hash-based
 * collection, it must properly implement the methods 
 * hashCode() and equals(), to guarantee the correct
 * behavior.
 */
class Item {
  
  String value;
  
  Item(String value) { 
    this.value = value; 
  }
  
  public String toString() { 
    return value;
  }
  
  /*
   * Method hashCode() will be used to decide 
   * in which HashSet bucket the object should be placed.
   */
  @Override
  public int hashCode() {
    return value.hashCode();
  }
  
  /*
   * Method equals() will be used to check if
   * object already exists in its attributed 
   * HashSet bucket.
   */
  @Override
  public boolean equals(Object other) {
    if (other instanceof Item) {
      return this.value.equals(((Item) other).value);
    }
    else
      return false;
  }
  
}

/*
 * An HashSet stores a collection of unique
 * objects in an unspecified order, therefore not
 * allowing duplicate values.
 * 
 * An HashSet can contain any object, but this object
 * must properly implement hashCode() and equals().
 */
public class AddingObjectsToHashSet {
  
  public static void main(String[] args) {
    
    HashSet<Item> set = new HashSet<Item>();
    Item p1 = new Item("Pen");
    Item p2 = new Item("Pineapple");
    Item p3 = new Item("Apple");
    Item p4 = new Item("Pen");
    set.add(p1);
    set.add(p2);
    set.add(p3);
    set.add(p4); // Duplicate string "Pen" not added to set.
    
    // Prints the contents, in no particular order.
    for (Item e : set) System.out.println(e);
  }
  
}
