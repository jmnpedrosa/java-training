package collections;

import java.util.HashSet;

/*
 * An HashSet stores a collection of unique
 * objects in an unspecified order, therefore not
 * allowing duplicate values.
 * 
 * The String class is safe to be immediately used
 * with a HashSet collection. It already implements
 * hashCode() and equals()
 */
public class AddingStringsToHashSet {
  
  public static void main(String[] args) {
    String str1 = new String("Pen");
    String str2 = new String("Pineapple");
    String str3 = new String("Apple");
    String str4 = new String("Pen");
    String str5 = null;
    
    HashSet<String> set = new HashSet<>();
    
    set.add(str1);
    set.add(str2);
    set.add(str3);
    set.add(str4); // Duplicate string "Pen" not added to set.
    set.add(str5); // "null" can be added, but only once
    
    // Prints the contents, in no particular order.
    for (String e : set) System.out.println(e);
  }
  
}
