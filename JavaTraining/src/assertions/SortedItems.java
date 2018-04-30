package assertions;

import java.util.List;

/*
 * Assertions work with boolean expressions, so you
 * can use a method on conjunction with the assertion,
 * as long as that method returns a boolean.
 */

class Item {}

class SortedItems {
  
	List<Item> students = null;
	
	private boolean sorted() {
		// returns true if list of items is sorted
		// false otherwise
		return true;
	}
	
	public void addItem(Item newItem) {
		assert sorted();
		// code to add new Item to list
	}
	
	public Item getItem(String itemId) {
		assert sorted();
		// code to search list and retrieve matching Item object
		return new Item();
	}
}
