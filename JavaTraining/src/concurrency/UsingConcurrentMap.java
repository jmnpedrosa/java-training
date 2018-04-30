package concurrency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/*
 * A ConcurrentHashMap is a thread-safe version of an HashMap
 * that includes atomic operations to add and remove elements.
 */

public class UsingConcurrentMap {
  
  static final ConcurrentMap<Integer, String> map = new ConcurrentHashMap<>();
  
  static {
    // Populate the Map, etc...
  }
  
  static void manipulateMap(Integer key, String value) {
    if (!map.containsKey(key))
      // Atomic operation that inserts a value if it does not exist yet.
      map.putIfAbsent(key, value);
  }
}
