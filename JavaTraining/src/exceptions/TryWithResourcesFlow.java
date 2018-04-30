package exceptions;

/*
 * In a try-with-resources, as long as the opened resource
 * implements Closeable or AutoCloseable, the method close()
 * is always called at the end of the "try" statement, 
 * before any "catch" or "finally" block is reached.
 */

class SomeResource implements AutoCloseable {
  
	SomeResource() {
		System.out.println("Constructor called");
	}
	
	public void close() {
		System.out.println("Close called");
	}
}

class ResourceManager {
  
	void trySomeResource() {
	  
		try (SomeResource res = new SomeResource();){
			System.out.println("within try-with-resources");
		}
		finally {
			System.out.println("finally");
		}
		
	}
}

public class TryWithResourcesFlow {
  
	public static void main(String args[]) {
		new ResourceManager().trySomeResource();
	}
	
}
