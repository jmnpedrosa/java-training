package threads;

/*
 * Methods that manipulate a shared resource should be marked as "synchronized"
 * to ensure that multiple concurrent threads always access them one at a time
 * and the contents remain consistent during code execution.
 */

class SharedData {
  int number = 0;
  
  synchronized public void increment() {
    ++number;
  }
  
  synchronized public void decrement() {
    --number;
  }
  
}

class Incrementer extends Thread {
  private SharedData data;
  
  public Incrementer(SharedData data) {
    this.data = data;
  }
  
  @Override
  public void run() {
    data.increment();
  }
}

class Decrementer extends Thread {
  private SharedData data;
  
  public Decrementer(SharedData data) {
    this.data = data;
  }
  
  @Override
  public void run() {
    data.decrement();
  }
}

public class UsingSynchronizedMethods {
  
  public static void main(String[] args) {
    SharedData data  = new SharedData();
    Thread task1 = new Incrementer(data); task1.start();
    Thread task2 = new Incrementer(data); task2.start();
    Thread task3 = new Decrementer(data); task3.start();
  }
  
}
