package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * A ReentrantLock can be used to synchronize the execution of
 * an operation with a higher degree of control than a "synchronized"
 * statement.
 * 
 * This is an example of how to appropriately use a ReentrantLock
 * and its methods to manage the calling of a method by
 * different threads.
 */

class Train {
  
  Lock lock = new ReentrantLock();
  
  public void boardTrain(String name) {
    System.out.println(name + ": boarded");
  }
  
}

public class Passenger extends Thread {
  
  Train train;
  String name;
  
  Passenger(String name, Train train) {
    this.train = train;
    this.name = name;
  }
  
  @Override
  public void run() {
    
    /*
     * Notice the usage of several "try"
     * statements to lock and unlock.
     */
    try {
      // Acquire a lock unless the current thread is interrupted
      train.lock.lockInterruptibly();
      try {
        train.boardTrain(name);
      } finally {
        // Release the lock
        train.lock.unlock();
      }
      
    } catch (InterruptedException e) {
      System.out.println(name + " : Interrupted!!");
      Thread.currentThread().interrupt();
    }
    
  }
  
  public static void main(String... args) {
    
    Train train = new Train();
    Passenger p1 = new Passenger("Alice", train);
    p1.start();
    p1.interrupt();
    
    Passenger p2 = new Passenger("Bob", train);
    p2.start();
    
  }
}
