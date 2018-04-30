package concurrency;

import java.util.concurrent.locks.ReentrantLock;

/*
 * A ReentrantLock can be used to synchronize the execution of
 * an operation with a higher degree of control than a "synchronized"
 * statement.
 */
public class UsingReentrantLock {
  
  ReentrantLock lock = new ReentrantLock();
  boolean locked = false;
  
  public void assumingDirectControl(String name) {
    
    /* Attempt a lock immediately, without waiting
     * for a lock to be acquired.
     */
    if (lock.tryLock()) {
      locked = true;
      System.out.println(name + ": boarded");
    }
  }
  
  public void relinquishingControl(String name) {
    
    // Check if the current thread holds this lock
    if (lock.isHeldByCurrentThread() && locked) {
      lock.unlock();
      locked = false;
      System.out.println(name + " : deboarded");
    }
  }
  
}
