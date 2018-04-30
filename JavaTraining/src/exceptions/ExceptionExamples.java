package exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * Examples of how you can and cannot apply exceptions
 * to base and derived classes.
 */

class LoginException extends Exception {
	public LoginException() {
		super();
	}
	public LoginException(String message) {
		super(message);
	}
}

public class ExceptionExamples {
	public void login(String user, String pwd) throws LoginException {
		if (!findInDatabase(user, pwd)) {
			throw new LoginException("Invalid username or password");
		}
	}

	private boolean findInDatabase(String user, String pwd) {
		// dummy method, never finds anything
		return false;
	}
}

class Base {
	public void noException() {}
	public void noRuntimeException() {}
}
class Derived extends Base {
//		public void noException() throws Exception {} // Won't compile, base class method has no "throws"
	public void noRuntimeException() throws RuntimeException {}
}

class Base1 {
	public void withException() throws IOException {}
	public void withRuntimeException() throws RuntimeException {}
}
class Derived1 extends Base1 {
	public void withException() {}
	public void withRuntimeException() {}
}

class Base2 {
	public void withIOException() throws IOException {}
	public void withRuntimeException() throws NullPointerException {}
}
class Derived2 extends Base2 {
	//	public void withIOException() throws Exception {} // Won't compile, base class method only throws "IOException" or lower.
	public void withRuntimeException() throws RuntimeException{}
}

class Base3 {
	void withIOException() throws IOException {}
	void methodUncheckedEx() throws Error {}
}
class Derived3 extends Base3 {
	void withIOException() throws IOException {}
	void methodUncheckedEx() throws NullPointerException {}
}

class Base4 {
	void aMethod() throws IOException {}
}
class Derived4 extends Base4 {
	void aMethod() throws FileNotFoundException {}
}