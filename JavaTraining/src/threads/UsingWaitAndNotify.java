package threads;

/*
 * Example that demonstrates the usage of wait() and notify() to keep
 * one thread awaiting for another one before completing its own execution.
 */

class Awaiter extends Thread {
  
  Notifier notifier;
  
  Awaiter(Notifier friend) {
    this.notifier = friend;
  }
  
  @Override
  public void run() {
    System.out.println("Notifier finished: " + notifier.finished);
    // Ensure a synchronized access to the notifier object
    synchronized (notifier) {
      try {
        // This thread will suspend execution until being notified by "notifier".
        notifier.wait();
      } catch (InterruptedException e) {
        System.out.println(e);
      }
    }
    System.out.println("Finished: " + notifier.finished);
  }
  
}

class Notifier extends Thread {
  
  boolean finished = false;
  
  @Override
  public void run() {
    while (!finished) {
      try {
        // Do nothing for 2 seconds.
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        System.out.println(e);
      }
      confirmFinished();
    }
  }
  
  public synchronized void confirmFinished() {
    finished = true;
    // Notify the thread (if there is one) that is awaiting for this one.
    // If there are multiple threads waiting, you should use notifyAll().
    notify();
  }
  
}

public class UsingWaitAndNotify {
  
  public static void main(String[] args) {
    Notifier notifierThread = new Notifier();
    Awaiter awaiterThread = new Awaiter(notifierThread);
    awaiterThread.start();
    notifierThread.start();
  }
  
}
