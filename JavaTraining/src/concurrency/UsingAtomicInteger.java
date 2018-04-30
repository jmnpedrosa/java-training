package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * AtomicInteger provides a thread-safe way of manipulating 
 * integer variables.
 */
public class UsingAtomicInteger {
  
  // Create a thread-safe integer with value 0.
  AtomicInteger myCounter = new AtomicInteger(0);
  
  public void increment() {
    // Atomically increments by 1 and returns the new value.
    myCounter.incrementAndGet();
  }
  
  public void decrement() {
    // Atomically decrements by 1 and returns the new value.
    myCounter.decrementAndGet();
  }
}
