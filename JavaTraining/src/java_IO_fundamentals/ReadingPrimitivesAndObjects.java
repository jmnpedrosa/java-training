package java_IO_fundamentals;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/*
 * ObjectInputStream and ObjectOutputStream can both be used to read primitives
 * and objects from and to a file.
 * 
 * Keep in mind that the data has to be retrieved in the order that it was written.
 * Of you try to read the data in an incorrect order, the runtime exception
 * OptionalDataException will be thrown.
 */

public class ReadingPrimitivesAndObjects {
  
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    
    try (FileInputStream in = new FileInputStream("object.data");
         ObjectInputStream ois = new ObjectInputStream(in);) {
      
      System.out.println(ois.readBoolean());
      MyObj c = (MyObj) ois.readObject();
      System.out.println(c.value);
    }
  }
}

class MyObj implements Serializable {
  
  private static final long serialVersionUID = 1L;
  String value;
  
  MyObj(String value) {
    this.value = value;
  }
}