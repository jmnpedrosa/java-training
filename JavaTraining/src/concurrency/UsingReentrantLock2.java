package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * How to appropriately apply a ReentrantLock on an operation.
 */
public class UsingReentrantLock2 {
  
  Lock myLock = new ReentrantLock();
  
  static List<String> items = new ArrayList<>();
  
  public void addItem(String newItem) {
    
    // Method lock() will block and wait until a lock is acquired.
    myLock.lock();
    
    // After calling lock() place your operation inside a "try" statement.
    try {
      items.add(newItem);
    } finally {
      // Ensure the lock is always released at the end by calling
      // unlock() inside the "finally" block.
      myLock.unlock();
    }
    
  }
}
