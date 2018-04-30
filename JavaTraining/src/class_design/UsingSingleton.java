package class_design;

/*
 * Demonstration of how a singleton object can be defined in Java. 
 */
class Singleton {
  
  // Define a private static variable that stores the sole instance of this class.
  // Only the class has direct access to it.
  private static Singleton anInstance = null;
  
  // Define a public method that returns the sole instance of this class
  // The method returns the existing instance (creating it first if it does not yet exist).
  // This process must be done in a thread-safe way.
  public static Singleton getInstance() {
    if (anInstance == null) {
      synchronized (Singleton.class) {
        if (anInstance == null)
          anInstance = new Singleton();
      }
    }
    return anInstance;
  }
  
  // Define constructor as private.
  // Only this class can construct instances of itself
  private Singleton() {
    System.out.println("Instance created");
  }
  
}

public class UsingSingleton {
  
  public static void main(String args[]) {
    Singleton singleton1 = Singleton.getInstance();
    Singleton singleton2 = Singleton.getInstance();
    System.out.println(singleton1 == singleton2);
  }
  
}