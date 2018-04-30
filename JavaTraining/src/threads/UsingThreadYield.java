package threads;

/*
 * Method yield() sends a request to the thread scheduler to suspend the execution of the
 * current thread and allow other threads to run first. Is sends only a hint and may be ignored
 * altogether by the system.
 */

public class UsingThreadYield {
  
	public static void main(String args[]) {
	  
		Thread thread = new Thread() {
		  @Override
		  public void run() {
		    yield(); // Requests Thread "thread" to suspend.
		    System.out.println("I have yielded.");
		  }
		};
		thread.start();
		Thread.yield(); // Requests current main thread to suspend.
	}
}