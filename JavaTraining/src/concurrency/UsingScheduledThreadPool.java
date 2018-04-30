package concurrency;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
 * An example of an ExecutorService that uses a scheduled thread pool,
 * executing a Runnable at a fixed interval.
 */

class Reminder implements Runnable {
  @Override
  public void run() {
    System.out.println("Reminder sent at " + new Date(System.currentTimeMillis()));
  }
}

public class UsingScheduledThreadPool {
  
  // Create a scheduled executor service with a fixed pool of 1 thread.
  ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
  Reminder reminder = new Reminder();
  
  public void sendReminders() {
    // This executor will run at a fixed rate of 5 seconds.
    service.scheduleAtFixedRate(reminder, 0, 5, TimeUnit.SECONDS);
  }
  public static void main(String[] args) {
    UsingScheduledThreadPool mgr = new UsingScheduledThreadPool();
    mgr.sendReminders();
  }
}
