package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * You can use Collections.sort() to sort a Lists of any type according to 
 * the natural order of its elements. This works well with Numbers,
 * Strings, or any class that implements Comparable.
 */

public class SortingLists {
  
	public static void main(String[] args) {
	  sortingListsOfPrimitives();
	  System.out.println();
	  sortingListsOfComparableObjects();
	}
	
	static void sortingListsOfPrimitives() {
	  List<Integer> integers = new ArrayList<>();
      integers.add(new Integer(200));
      integers.add(new Integer(87));
      integers.add(new Integer(999));
      
      for (Integer i : integers) {
          System.out.println(i);
      }
      
      System.out.println("After calling Collections.sort()");
      Collections.sort(integers);
      
      for (Integer i : integers) {
          System.out.println(i);
      }
	}
	
	static void sortingListsOfComparableObjects() {
	  Star s1 = new Star("Sun", 7777.77);
      Star s2 = new Star("Sirius", 999999.99);
      Star s3 = new Star("Pilatim", 222.22);
      
      List<Star> list = new ArrayList<>();
      list.add(s1); list.add(s2); list.add(s3);
      
      Collections.sort(list);
      
      list.add(new Star("Litmier", 4444.44));
      
      // Reverse the current order of the list.
      Collections.reverse(list);
      
      for (Star star:list) System.out.println(star);
	}
}

class Star implements Comparable<Star> {
	String name;
	double mass;
	
	Star(String name, double mass) {
		this.name = name;
		this.mass = mass;
	}
	
	public int compareTo(Star other) {
		return (int) (this.mass - other.mass);
	}
	
	public String toString(){
		return name + ":" + mass;
	}
}