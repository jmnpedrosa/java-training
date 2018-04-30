package threads;

// Define a thread by creating a class that extends from thread
class Thread1 extends Thread {
    // ...and override its run() method.
	@Override
	public void run() {
		System.out.println("This is Thread1.....");
	}
}

public class StartingThread {
  
	public static void main(String... args) {
	    // Instantiate your thread.
		Thread thread = new Thread1();
		// Call the start() method.
		thread.start();
		System.out.println("This is main");
	}
	
}