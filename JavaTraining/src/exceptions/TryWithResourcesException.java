package exceptions;

/*
 * In a try-with-resources, as long as the opened resource
 * implements Closeable or AutoCloseable, the method close()
 * is always called at the end of the "try" statement, even
 * if an exception is thrown before.
 * 
 * In this example, method close() is called after the exception
 * in readData() is thrown, but before entering the "catch" block.
 */

class DataReader implements AutoCloseable {
  
	public DataReader() {
		System.out.println("Opened DataReader");
	}
	
	public void readData() throws Exception {
		System.out.println("Reading Data");
		throw new Exception("Reading Data exception!");
	}
	
	@Override
	public void close() throws Exception {
		System.out.println("Closed DataReader");
	}
	
}

public class TryWithResourcesException {
  
	public static void main(String[] args) {
		try (DataReader dataReader = new DataReader();) {
			dataReader.readData(); // Exception is thrown here
			// close() is called here anyway
		}
		catch (Exception e) {
		    // enters here after calling close()
			System.out.println("Exception caught: " + e);
		}
	}
	
}
