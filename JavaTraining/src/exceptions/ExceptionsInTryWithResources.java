package exceptions;
/*
 * The resource inside a "try-with-resources" can be
 * any class that implements Closeable or AutoCloseable.
 * 
 * In the following example, the overridden method close() is
 * automatically called at the end of the "try" block, EVEN if
 * an exception is thrown or if close() was already manually called.
 * 
 * Therefore the output will be:
 * 
 * close
 * close
 * catch:java.lang.Exception
 * finally
 */

class Box implements AutoCloseable {
    /* 
     * This close() method throws an exception, causing the control
     * to exit the "try" block
     */
	public void close() throws Exception {
		System.out.println("close");
		throw new Exception();
	}
}

class ExceptionsInTryWithResources {
	public static void main(String args[]) {
		try (Box box = new Box()) {
			box.close(); // will exit the "try"
			/* a second implicit "close()" is called at this point */
			box.close(); // never reaches this line
		}
		catch (Exception e) {
		    // enters here
			System.out.println("catch:" + e);
		}
		finally {
		    // and always enters here in the end
			System.out.println("finally");
		}
	}
}

