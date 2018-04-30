package collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/*
 * If a TreeSet contains objects with a natural order
 * (defined by a Comparable implementation) but is initialized
 * with a different Comparator instead, then the Comparator is
 * the one used for sorting.
 */

public class TreeSetWithComparatorAndComparable {
  
	public static void main(String args[]) {
	  
	    // Create a TreeSet an pass a custom Comparator.
		TreeSet<Metal> set = new TreeSet<>(new Comparator<Metal>(){
		    // Order by "atomicNumber"
			public int compare(Metal m1, Metal m2) {
				return (m1.atomicNumber - m2.atomicNumber);
			}
		});
		
		Metal m1 = new Metal("Iron", 26);
		Metal m2 = new Metal("Aluminium", 13);
		Metal m3 = new Metal("Titanium", 22);
		
		set.add(m1);
		set.add(m2);
		set.add(m3);
		
		Iterator<Metal> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + ":");
		}
	}
	
}

/*
 * Class metal defines its natural order as being
 * the natural order of the String "name".
 */
class Metal implements Comparable<Metal>{
  
	String name;
	int atomicNumber;
	
	Metal(String name, int atomicNumber) {
		this.name = name;
		this.atomicNumber = atomicNumber;
	}
	
	public int compareTo(Metal other) {
		return name.compareTo(other.name);
	}
	
	public String toString() {
	  return name;
	}
}