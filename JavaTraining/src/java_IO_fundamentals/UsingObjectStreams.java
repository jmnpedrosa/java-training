package java_IO_fundamentals;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class ObjectFromFile implements Serializable {
  private static final long serialVersionUID = 1L;
}

public class UsingObjectStreams {
  
  public static void main(String[] args) throws Exception {
    
    try (FileOutputStream out = new FileOutputStream("object.data");
         ObjectOutputStream oos = new ObjectOutputStream(out);
         FileInputStream in = new FileInputStream("object.data");
         ObjectInputStream ois = new ObjectInputStream(in);) {
      
      ObjectFromFile c = new ObjectFromFile();
      oos.writeObject(c);
      oos.flush();
      ObjectFromFile c2 = (ObjectFromFile) ois.readObject();
      System.out.println(c2);
    }
    
  }
}
