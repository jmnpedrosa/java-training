package innerclasses;

/* A simple representation of a node structure,
 * like the ones used for linked lists.
 */
class Node {
	Object value;
	Node left, right;
}

class UsingInnerClasses {
  
	UsingInnerClasses() {}
	
	Node rootNode;
	
	void addElement(Object value) {
		// Adds an element...
	}
	
	void removeElement(Object value) {
		// Removes an element...
	}
	
	void sortTree(boolean ascending) {
		new TreeSort(ascending).sort();
	}
	
	/* A inner class that defines a sorting algorithm
	 * specific for its outer class only
	 */
	class TreeSort {
	  
		boolean ascendingSortOrder = true;
		
		TreeSort(boolean order) {
			ascendingSortOrder = order;
		}
		
		void sort() {
			// Does some sorting...
		}
	}
}

class Outer1 {
    // You can define an *instance* object of an inner class before
    // you define that inner class.
	Inner objectInner = new Inner();
	class Inner {}
}

class Outer2 {
	Inner in = new Inner();
	class Inner {}
	void aMethod () {
	    // You can define a local variable object of an inner class in
	    // an outer class method.
		Inner objectInner = new Inner();
	}
}

class Outer3 {
	class Inner {}
	// Cannot define an instance of an 
	// inner class in a static context.
	static void staticMethod() {
		// Inner in = new Inner(); // Won't compile
	}
}

// Different ways to instantiate an inner class.
class Outer4 {
	class Inner {}
	static void staticMethod () {
		Outer4 outObj = new Outer4();
		Inner innerObj = outObj.new Inner();
		Inner innerObj1 = new Outer4().new Inner();
	}
}

// Instantiating an inner class from outside its outer class.
class Foo {
	Outer4.Inner inner;
	Foo () {
		Outer4 outer = new Outer4();
		inner = outer.new Inner();
	}
}