package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * You can also use Collections.sort() to sort a List of any type according to 
 * the order specified by a Comparator that you can pass as an argument.
 * 
 * Comparator objects are useful when you wish to have multiple searching or 
 * sorting criteria, instead of just one natural sorting order.
 */

public class SortedSearch {
  
	static final Comparator<Integer> MY_INT_COMPARATOR = new Comparator<Integer>() {
		public int compare (Integer n1, Integer n2) {
		    // This will sort from the largest to the smallest Integer.
			return n2.compareTo(n1);
		}
	};
	
	public static void main(String args[]) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(9999);
		list.add(10);
		list.add(55);
		list.add(28);
		
		// Sorts by natural order.
		Collections.sort(list, null);
		System.out.println(list);
		
		/* Search for occurrence of element 55 on the sorted list
		 * using binary search.
		 */
		System.out.println(Collections.binarySearch(list, 55));
		
		// Sorts by the order the Comparator specifies.
		Collections.sort(list,MY_INT_COMPARATOR);
		System.out.println(list);
		
		/* Search for occurrence of element 55 on the sorted list
         * using binary search.
         */
		System.out.println(Collections.binarySearch(list, 55));
	}
}