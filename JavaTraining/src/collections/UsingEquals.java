package collections;

import java.util.ArrayList;

public class UsingEquals {
  public static void main(String[] args) {

    // Create an ArrayList of Citizen objects
    ArrayList<Citizen> list = new ArrayList<Citizen>();

    list.add(new Citizen(1, "Holly"));
    list.add(new Citizen(2, "Molly"));
    list.add(new Citizen(3, "Betty"));
    list.add(new Citizen(1, "Holly"));
    
    // Prints "4"
    System.out.println(list.size());

    Citizen citizen = new Citizen(1, "Holly");
    
    /* Tries to remove object referred to "citizen" from list.
     * Remember it removes only the first occurrence, if there are
     * several.
     */
    list.remove(citizen);

    // If "citizen" was found and removed, will print "3".
    System.out.println(list.size());
  }
}

class Citizen {
  
  int id;
  String name;
  
  Citizen(int id, String name) {
    this.id = id;
    this.name = name;
  }
  
  /*
   * The default equals() method from the Object class
   * must be overridden to determine what makes two 
   * "Citizens" equal. In this case both the "id" and "name"
   * Strings must be equal.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Citizen) {
      Citizen emp = (Citizen)obj;
      if (emp.id == this.id && emp.name.equals(this.name))
        return true;
    }
    return false;
  }
  
}