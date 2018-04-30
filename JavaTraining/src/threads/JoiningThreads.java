package threads;

/*
 * Calling the method join() on a Thread will cause the
 * current thread to suspend execution and wait until the other
 * Thread has finished its own execution.
 */

class Counter extends Thread {
  @Override
  public void run() {
    for (int i = 0; i < 5; i++) System.out.println(i);
  }
}

public class JoiningThreads {
  
  public static void main(String[] args) {
    Counter counter = new Counter(); 
    counter.start();
    
    try {
      System.out.println("Waiting for counter to complete");
      counter.join();
      System.out.println("Counter has finished.");
    } catch (InterruptedException e) {
      System.out.println(e);
    }
    
  }
}
