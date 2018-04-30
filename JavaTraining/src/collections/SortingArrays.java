package collections;

import java.util.Arrays;

/*
 * You can use Arrays.sort() to sort an array of any type according to 
 * the natural order of its elements. This works well with Numbers,
 * Strings, or any class that implements Comparable.
 */

public class SortingArrays {
  
	public static void main(String[] args) {
		int[] ints = {20, 14, 4, 10, 5, 3};
		
		for (int a: ints) System.out.print(a + " ");
		Arrays.sort(ints); // Sorts the whole array.
		System.out.println();
		
		for (int a: ints) System.out.print(a + " ");
		System.out.println();
		
		ints = new int[]{20, 14, 4, 10, 5, 3};
		for (int a: ints) System.out.print(a + " ");
		Arrays.sort(ints, 1, 5); // Sorts from index 1 to 4.
		System.out.println();
		
		for (int a: ints) System.out.print(a + " ");
		
		System.out.println();
		
		/* 
		 * Notice that upper case chars are lexicographically
		 * lower than lower case chars.
		 */
		String[] strings = {"abC", "aBC", "AbC", "ABc", "Abc"};
		for (String str: strings) System.out.print(str + " ");
		Arrays.sort(strings);
		System.out.println();
		for (String str: strings) System.out.print(str + " ");
	}
	
}
