package java_IO_fundamentals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * To write objects to a file, the object written must implement
 * the Serializable interface.
 * 
 * Notice that is said object extends from a parent, the parent needs not
 * to be a Serializable too (only the child).
 */

class Vehicle {
  String name = "Vehicle";
}

class Automobile extends Vehicle implements Serializable {
  private static final long serialVersionUID = 1L;
  String model = "Luxury";
}

public class WritingSerializableObjects {
  
  public static void main(String[] args) throws Exception {
    
    try (FileOutputStream out = new FileOutputStream("object.data");
         ObjectOutputStream oos = new ObjectOutputStream(out);
         FileInputStream in = new FileInputStream("object.data");
         ObjectInputStream ois = new ObjectInputStream(in);) {
      
      Automobile auto = new Automobile();
      oos.writeObject(auto);
      oos.flush();
      Automobile auto2 = (Automobile) ois.readObject();
      System.out.println(auto2.name + ":" + auto2.model);
    }
  }
}
