package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * An example of an ExecutorService that uses a fixed thread pool,
 * and of Callable statements being passed to it.
 */

class FoodRequest implements Callable<Void> {
  
  String description;
  
  FoodRequest(String name) {
    this.description = name;
  }
  
  @Override
  public Void call() throws Exception {
    System.out.println(description);
    if (description.equalsIgnoreCase("chicken"))
      throw new Exception("Chicken unavailable");
    return null;
  }
  
}

public class UsingFixedThreadPool {
  
  // Create an executor service with a fixed pool of 5 threads.
  ExecutorService service = Executors.newFixedThreadPool(5);

  public void orderFood(FoodRequest order) {
    service.submit(order);
  }
  
  public void pubClosedToday() {
    service.shutdown();
  }
  
  // This is how you gracefully shut down a service for good.
  public void pubClosedForever() {
    
    service.shutdown();
    try {
      if (!service.awaitTermination(60, TimeUnit.SECONDS)) {
        service.shutdownNow();
        if (!service.awaitTermination(60, TimeUnit.SECONDS))
          System.err.println("Pool did not terminate");
      }
    } catch (InterruptedException ie) {
      service.shutdownNow();
      Thread.currentThread().interrupt();
    }
    
  }
}
