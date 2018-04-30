package collections;

import java.util.Map;
import java.util.TreeMap;

/*
 * In this example, a TreeMap stores a collection of <key, value> pairs
 * sorted by their natural order (if the keys implement Comparable).
 */

class Key implements Comparable<Key> {
	String name;
	
	Key(String name) {
		this.name = name;
	}
	
	/* These objects are compared by their name attribute. */
	public int compareTo(Key f) {
		return this.name.compareTo(f.name);
	}
}

public class CreatingTreeMap {
  
	public static void main(String[] args) {
		Map<Key, String> flavorMap = new TreeMap<>();
		flavorMap.put(new Key("aaaa"), "Value One");
		flavorMap.put(new Key("aaab"), "Value Two");
		System.out.println(flavorMap.get(new Key("aaab"))); // Prints "Value Two"
	}
	
}
