package java_IO_fundamentals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * When reading and writing data to a file, fields marked as "transient" are
 * not serialized, i.e., their values are lost. When you try to retrieve them
 * in the example below, the deserialization assigns them default values.
 */

class Bike implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  String name;
  transient String model;
  transient int days;
  static int bikeCount;
  
  Bike(String value) {
    name = value;
    model = "Orbita";
    days = 98;
    ++bikeCount;
  }
}

public class UsingTransientVariablesInStreams {
  
  public static void main(String[] args) throws Exception {
    
    try (FileOutputStream out = new FileOutputStream("D:\\object.data");
         ObjectOutputStream oos = new ObjectOutputStream(out);
         FileInputStream in = new FileInputStream("D:\\object.data");
         ObjectInputStream ois = new ObjectInputStream(in);) {
      
      Bike c = new Bike("MyBike");
      oos.writeObject(c);
      oos.flush();
      
      new Bike("YourBike");
      
      Bike c2 = (Bike) ois.readObject();
      System.out.println(c2.name);
      System.out.println(c2.model + " " + c2.days);
      System.out.println(c2.bikeCount);
    }
  }
}
