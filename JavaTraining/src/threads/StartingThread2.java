package threads;

// Define a thread by creating a class that implements Runnable
class Thread2 implements Runnable {
    // ...and override its run() method.
	@Override
	public void run() {
		System.out.println("This is Thread2.....");	
	}
}

public class StartingThread2 {
  
	public static void main(String... args) {
	    // Instantiate a Thread object and pass your class as an argument.
		Thread thread = new Thread(new Thread2());
		// Call the start() method.
		thread.start();
		System.out.println("This is main");
	}
	
}