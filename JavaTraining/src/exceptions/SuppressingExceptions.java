package exceptions;

/*
 * In a try-with-resources, as long as the opened resource
 * implements Closeable or AutoCloseable, the method close()
 * is always called at the end of the "try" statement, even
 * if an exception is thrown before.
 * 
 * If the close() method throws another exception after the
 * first one, this second exception is suppressed by the first
 */

public class SuppressingExceptions {
  
	public static void main(String[] args) throws Exception {
	  
		try ( MyDataResource dataReader = new MyDataResource(); ) {
			dataReader.readData(); // Exception is thrown here
			// close() is called here, throwing another exception
		}
		catch (Exception e) {
		    // The first exception is caught here, with the second
		    // one being suppressed.
			System.out.println("Exception caught: " + e);
			// getSuppressed() returns any Throwables that were suppressed
			// by the current one.
			Throwable[] exs = e.getSuppressed();
			if (exs.length > 0)
				System.out.println("Suppressed Exception: " + exs[0]);
		}
	}
	
}

class MyDataResource implements AutoCloseable {
  
	public MyDataResource() {
		System.out.println("Opened MyDataResource");
	}
	
	public void readData() throws Exception {
		System.out.println("Reading Data");
		throw new Exception("Reading Data exception!");
	}
	
	public void close() throws Exception {
		System.out.println("Closed MyDataResource");
		throw new Exception("Closing MyDataResource exception!");
	}
}