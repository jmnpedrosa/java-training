package generics;

/* Another example of mixing up generics with non-generics, something
 * that is bound to happen often in maintenance of older software.
 * 
 * Try switching the Container class with it's non-generic version
 * and see what happens.
 */

/* Non-generic version of class Container */
//class Container {
//  private Object obj;
//  public void set(Object obj) {
//    this.obj = obj;
//  }
//  public Object get() {
//    return obj;
//  }
//}

/* Generic version of class Container */
class Container<T> {
  private T obj;
  public void set(T obj) {
    this.obj = obj;
  }
  public T get() {
    return obj;
  }
}

class Glass {}
class Cardboard {}

class RawTypesInteroperability2 {
  
  public static void main(String[] args) {
    
    // Without using type safety (causes compiler warnings)
    Container container1 = new Container();
    container1.set(new Cardboard());
    System.out.println((Glass) container1.get()); // Throws ClassCastException
    
    // Using type safety
    Container<Cardboard> container2 = new Container<>();
    container2.set(new Cardboard());
    Cardboard cardboard = container2.get();
  }
  
}

interface MyMap<K, V>{
  void put(K key, V value);
  V get(K key);
}
