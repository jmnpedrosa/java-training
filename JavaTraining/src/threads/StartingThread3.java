package threads;

// Define a thread by creating a class that extends from thread
class Thread3 extends Thread {
    // ...and override its run() method.
    @Override
	public void run() {
		System.out.println("This is Thread3.....");
	}
}

public class StartingThread3 {
  
	public static void main(String... args) {
	    // You can create your thread...
		Thread thread = new Thread3();
		// ... and another thread that takes your thread as an argument
		Thread newThread = new Thread(thread);
		// And call start() on the outer thread; your inner thread will run!
		newThread.start();
	}
	
}