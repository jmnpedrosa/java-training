package assertions;

/*
 * You can use assertions to detect an unexpected
 * condition in your code, for example at the end
 * of an if-else statement.
 */

public class InternalAssumption {
    
    // some class code
    
	void transmitFile(String protocol, String fileName) {
	  
		if (protocol.equals("FTP")) {
			//..code to transmit file using FTP
		}
		else if (protocol.equals("HTTP")) {
			//..code to transmit file using HTTP
		}
		else if (protocol.equals("HTTPS")) {
			//..code to transmit file using HTTPS
		}
		else {
		    // code should never enter here
			assert false : "Only FTP, HTTP, HTTPS supported";
		}
		
	}
}
