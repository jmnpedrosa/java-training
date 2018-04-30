package exceptions;

import java.io.IOException;

/*
 * Careful when using multi-catch. The variable type of the 
 * exception caught is always the default "Exception".
 */

class BaseException extends IOException {
	public String info() {
		return "I'm Base Exception";
	}
}
class DerivedException extends Exception {
	public String info() {
		return "I'm Derived Exception";
	}
}

public class TestVariableTypeInMultiCatch {
	public static void main(String[] args) {
		try {
			int a = 10;
			if (a <= 10)
			  throw new BaseException();
			else
			  throw new DerivedException();
		} catch (BaseException | DerivedException e) {
		    // Will not compile, because "e" is of type exception
		    // and does not define method info().
		  
			// System.out.println(e.info()); 
		  
		    if (e instanceof BaseException) {
		      System.out.println(((BaseException) e).info()); 
		    } else if (e instanceof DerivedException) {
              System.out.println(((DerivedException) e).info()); 
            }
		}
	}
}
