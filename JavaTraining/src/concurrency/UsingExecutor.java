package concurrency;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;

/* 
 * An Executor is a basic Interface that allows you to
 * specify a group of tasks to be executed asynchronously.
 */

class Order implements Runnable {
  
  String name;
  
  Order(String name) {
    this.name = name;
  }
  
  @Override
  public void run() {
    System.out.println(name);
  }
  
}

public class UsingExecutor implements Executor {
  
  final Queue<Runnable> custQueue = new ArrayDeque<>();
  
  @Override
  public void execute(Runnable r) {
    synchronized (custQueue) {
      custQueue.offer(r);
    }
    processEarliestOrder();
  }
  
  private void processEarliestOrder() {
    synchronized (custQueue) {
      Runnable task = custQueue.poll();
      new Thread(task).start();
    }
  }
  
}
