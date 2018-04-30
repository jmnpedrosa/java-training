package generics;

import java.util.Stack;

/*
 * Issues can occur when you integrate generics-supported code with
 * legacy non-generic code. In this example method pushItems() works with RAW types,
 * allowing you to push the wrong type of object into a collection.
 */
public class RawTypesInteroperability {

  public static void pushItem(Stack stack, Object obj) {
    // With no definition of generics, any type of object will be pushed.
    stack.push(obj);
  }

  public static void main(String args[]) {
    // Create a stack of Strings and push a String into it.
    Stack<String> stack = new Stack<String>();
    stack.push("CuteString");
    // Will successfully push an Integer into the stack of Strings.
    pushItem(stack, new Integer(1));
    // Will throw ClassCastException, because it pops an Integer instead of String.
    String value = stack.pop();
    System.out.println(value);
  }
}
