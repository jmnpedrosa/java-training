package class_design;

/*
 * Static initialization blocks execute as soon
 * as the class is loaded in memory, by the order they appear
 * and before any instance initialization blocks or
 * class constructors.
 */

class UsingStaticInitBlocks {
  
    /* staticVar is initialized with value 10 */
	static int staticVar = 10;
	
	/* then it is incremented to 11 */
	static {
		System.out.println("First");
		++staticVar;
	}
	
	/* and then incremented to 12 */
	static {
		System.out.println("Second");
		++staticVar;
	}
	
	static void modifyStaticVar() {
		++staticVar;
	}
	
	/* Constructor will print at least "12" */
	public UsingStaticInitBlocks() {
		System.out.println("Constructor:" + staticVar);
	}
	
	public static void main(String[] args) {
	  
	    /* "First" and "second" will be printed
	     * here, before any constructor is called.
	     */
		new UsingStaticInitBlocks(); // prints "12"
		modifyStaticVar(); // increments to "13"
		new UsingStaticInitBlocks(); // prints "13"
		
	}
}
