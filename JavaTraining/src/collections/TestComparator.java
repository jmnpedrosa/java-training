package collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

// This class has no defined sorting.
class Persona {
  
	String name;
	int age;
	
	Persona(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String toString() {
		return name;
	}
}

/*
 * You can (and must) use a TreeSet with a Comparator class, in order
 * to store its items in a specified order, when these have no
 * natural order.
 */

public class TestComparator {
  
	public static void main(String[] args) {
	  
		TreeSet<Persona> set = new TreeSet<>(
		    // Defining a comparator here as an anonymous inner class
				new Comparator<Persona>(){
					public int compare(Persona p1, Persona p2) {
						return (p1.age - p2.age);
					}
				}
		);
		set.add(new Persona("George", 12));
		set.add(new Persona("Johnny", 40));
		set.add(new Persona("Gelson", 30));
		
		Iterator<Persona> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
