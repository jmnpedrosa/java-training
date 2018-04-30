package assertions;
/**
 * Example of how (not) to use a Java assertion.
 * 
 * Although you can catch AssertionErrors, you should not base
 * control of your application in those.
 * 
 * Assertions are optional and disabled by default.
 * You can enable them using "java -ea" or "java -enableassertions".
 */

class WrongAsserting {
  
	public void construction(double load){
	  
	    // We instantiate some variable.
		double maxLoad = 1322976;
		// There are some fancy calculations in here to maxLoad
		try {
			if (maxLoad > 18753) assert false; // Will throw an AssertionError if the condition is true.
		}
		catch (AssertionError e) {
			// Control will enter here.
		}
	}
	
}