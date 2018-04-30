package concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
 * ReadWrite lock contains two locks, one for reading and one
 * for writing, that work in unison.
 * 
 * https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/locks/ReadWriteLock.html
 */

public class UsingReadWriteLock {
  
  private final ReadWriteLock myLock = new ReentrantReadWriteLock();
  private static int pos;
  static Map<Integer, String> items = new HashMap<>();

  public void addItem(String newItem) {
    
    // Method lock() will block and wait until a lock is acquired.
    myLock.writeLock().lock();
    
    // After calling lock() place your operation inside a "try" statement.
    try {
      items.put(new Integer(++pos), newItem);
    }
    finally {
      // Ensure the lock is always released at the end by calling
      // unlock() inside the "finally" block.
      myLock.writeLock().unlock();
    }
  }

  public void display() {
    
    // Method lock() will block and wait until a lock is acquired.
    myLock.readLock().lock();
    
    // After calling lock() place your operation inside a "try" statement.
    try {
      for (String s : items.values()) {
        System.out.println(s);
      }
    }
    finally {
      // Ensure the lock is always released at the end by calling
      // unlock() inside the "finally" block.
      myLock.readLock().unlock();
    }
  }
}
