package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class City {
  
  String name;
  
  City(String name) {
    this.name = name;
  }
  
  public String toString() {
    return name;
  }
}

public class UsingLinkedHashSet {
  
  public static void main(String[] args) {
    
    Set<City> route = new LinkedHashSet<>();
    
    route.add(new City("Lisbon"));
    route.add(new City("Madrid"));
    route.add(new City("Paris"));
    
    List<City> extendedRoute = new ArrayList<>();
    extendedRoute.add(new City("London"));
    extendedRoute.add(new City("Berlin"));
    
    route.addAll(extendedRoute);
    
    Iterator<City> iter = route.iterator();
    while (iter.hasNext()) {
      System.out.println(iter.next());
      // This will print false because City doesn't override equals().
      System.out.println(route.contains(new City("London"))); 
    }
    
  }
  
}
