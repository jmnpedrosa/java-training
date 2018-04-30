package innerclasses;

/*
 * A series of examples of outer and inner classes,
 * and how they can be accessed.
 */

class Outer {
	static int outerStatic = 10;
	int outerInstance = 20;
	
	/*
	 * A static nested class can have both static or instance fields.
	 */
	static class StaticNested {
		static int innerStatic = 10;
		int innerInstance = 20;
	}
	
	public static void main(String args[]) {
		StaticNested nested1 = new StaticNested();
		Outer.StaticNested nested2 = new Outer.StaticNested();
		nested1.innerStatic = 99;
		nested1.innerInstance = 999;
		System.out.println(nested1.innerStatic + ":" + nested1.innerInstance);
		System.out.println(nested2.innerStatic + ":" + nested2.innerInstance);
	}
}

class AnotherClass {
    // Inner class static nested can be accessed by prefixing the outer class's name
	Outer.StaticNested nested1 = new Outer.StaticNested();
	//	StaticNested nested2 = new StaticNested(); // This Won't compile
}

class OuterB {
	public static void main(String args[]) {
	    // You must instantiate a inner class to access its instance variable.
		System.out.println(new Outer.StaticNested().innerInstance);
		// You can access a static variable without instantiating the inner class.
		System.out.println(Outer.StaticNested.innerStatic);
	}
}

interface Floatable {
	void floating();
}
class AdventureCamp {
    // An anonymous inner class that implements Floatable.
    // Notice the usage of "new" followed by the interface name.
	Floatable floatable = new Floatable() { public void floating() {}};
}

interface Admissible {} 

class University {
	static void admit(Admissible adm) {
		System.out.println("admission complete");
	}
	public static void main(String args[]) {
	    // It is frequent to see anonymous inner classes passed as
	    // method parameters.
		admit(new Admissible(){}); 
	}
}