package collections;

import java.util.ArrayDeque;
import java.util.Arrays;

/*
 * An ArrayDeque can work as a bidirectional List and as a Stack,
 * and includes methods to support both types of operations.
 */

public class TestArrayDeque {
  
  public static void main(String[] args) {
    //String array
    String strArray[] = {"A1", "B2", "C3"};
    
    // Creates ArrayDeque from String List; Arrays.asList converts array to List.
    ArrayDeque<String> arrDeque = new ArrayDeque<>(Arrays.asList(strArray));
    
    // push() adds element to Deque beginning
    arrDeque.push("D4");
    // offer() adds element at Deque end
    arrDeque.offer("E5");
    
    // Can't add null to ArrayDeque; will throw NullPointerException
    try {
      arrDeque.push(null);
    } catch (Exception e) {
      System.out.println(e);
    }
    
    // pop() returns and removes element at Deque beginning
    System.out.println(arrDeque.pop());
    // remove() also returns and removes element at Deque beginning
    System.out.println(arrDeque.remove());
    
    // add() adds an element to end of queue
    arrDeque.add("F6");
    // peek() queries and returns element at beginning of queue
    System.out.println(arrDeque.peek());
    
    System.out.println(arrDeque);
  }
  
}
