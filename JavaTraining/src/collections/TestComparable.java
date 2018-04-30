package collections;

import java.util.Iterator;
import java.util.TreeSet;

/*
 * A class that implements Comparable defines a natural order
 * for its elements, that can be used for sorting with Collection
 * objects.
 */

class Person implements Comparable<Person> {
  
	String name;
	int age;
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// Must implement compareTo()
	public int compareTo(Person person) {
		return (this.age - person.age);
	}
	
	public String toString() {
		return name;
	}
}

public class TestComparable {
  
	public static void main(String[] args) {
	  
	    /*
	     * This TreeSet is initializes without a comparator, so
	     * it stores items in their natural order, using their
	     * compareTo() implementation.
	     */
		TreeSet<Person> set = new TreeSet<>();
		set.add(new Person("George", 12));
		set.add(new Person("Johnny", 40));
		set.add(new Person("Gelson", 30));
		
		Iterator<Person> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
}
