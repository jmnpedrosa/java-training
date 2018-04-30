package generics;

import java.util.ArrayList;
import java.util.List;

/*
 * You can refer to a list of an unknown type with 
 * the wildcard <?>. In that case you can retrieve items
 * into variables of type Object only.
 */

class Superclass {}

class Subclass extends Superclass {
  
  String id;
  
  Subclass(String id) {
    this.id = id;
  }
  
  public String toString() {
    return id;
  }
}

class Courier {
  
  // you can iterate through a list of unknown type
  // by refering to its classes as Objects
  public static void wrapGift(List<?> list) {
    for (Object item : list) {
      System.out.println("GiftWrap - " + item);
    }
  }
  
  public static void main(String args[]) {
    List<Subclass> classList = new ArrayList<Subclass>();
    classList.add(new Subclass("soisoisoi"));
    classList.add(new Subclass("lolololol"));
    wrapGift(classList);
    List<String> stringList = new ArrayList<String>();
    stringList.add("Alice");
    stringList.add("Bob");
    wrapGift(stringList);
  }
  
}