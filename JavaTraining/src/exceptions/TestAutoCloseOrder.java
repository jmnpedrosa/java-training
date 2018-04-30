package exceptions;

/*
 * In a try-with-resources with multiple resources,
 * these are automatically closed at the end of the "try"
 * block, in the reverse order by which they were opened.
 */

class MyResource implements AutoCloseable{
  
	String name;
	
	MyResource(String name) {
		this.name = name;
		System.out.println("Created: "+ name);
	}
	
	public void close() {
		System.out.println("Closed:" + name);
	}
}

public class TestAutoCloseOrder {
  
	public static void main(String args[]) {
	    // Call a try with multiple resources, 
	    // separated by a semicolon (";")
		try (MyResource res1 = new MyResource("1");
			 MyResource res2 = new MyResource("2")) {
			System.out.println("within try-with-resources");
		}
		finally {
			System.out.println("finally");
		}
	}
	
}
