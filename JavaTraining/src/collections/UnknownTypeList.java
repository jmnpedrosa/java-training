package collections;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * Example of how a generic list of an unknown
 * type can be instantiated. Notice that get() will
 * return a reference variable of type Object.
 */
public class UnknownTypeList {
  
  public static void main(String args[]) {
    String myArray[] = {"Pen", "Pineapple", "Apple", "Pen"};
    List<?> myList = new LinkedList<>(Arrays.asList(myArray));
    System.out.println(myList.get(0));
  }
  
}
