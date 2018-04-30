package generics;

/*
 * Using a bounded type parameter, it's possible to limit the parameter types
 * that you can pass to a generic class, interface or method.
 */
abstract class Gift {
  abstract double getWeight();
}

class Ebook extends Gift {
  public double getWeight() { return 2.2; }
}

class Smartphone extends Gift {
  public double getWeight() { return 1.1; }
}

/*
 * MyParcel is a generic class that accepts only a generic type T
 * that may be a "Gift" or subclass of "Gift".
 */
class MyParcel<T extends Gift> {
  private T t;
  public void set(T t) {
    this.t = t;
  }
  public void shipParcel() {
    // Although type variable "t" is a generic, we know it
    // extends "Gift", so it contains a getWeight() method.
    if (t.getWeight() > 10)
      System.out.println("Ship by courier ABC");
    else
      System.out.println("Ship by courier XYZ");
  }
}


interface Wrappable {}
interface Exchangeable {}
class Present {}
// Defines a generic class whose type T is a sub-type of all
// 3 types above.
class Parcel2 <T extends Present, Exchangeable, Wrappable>{}