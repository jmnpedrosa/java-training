package assertions;

/*
 * You can use assertions to detect an unexpected
 * condition in your code, such as a default value
 * in a "switch" statement (that should not exist).
 */

enum State {ON, OFF};

public class InternalAssumptionWithAssert {
    
    // some class code...
    
	void machineState(State state) {
	  
		switch (state) {
		  case ON: System.out.println("state is ON");
		break;
		  case OFF: System.out.println("state is OFF");
		break;
		  default: assert false; // should not happen
		}
		
	}
}
