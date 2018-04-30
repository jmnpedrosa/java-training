package java_IO_fundamentals;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UsingDataInputStream {
  
  public static void main(String[] args) throws IOException {
    
    try (FileOutputStream fos = new FileOutputStream(new File("D:\\myData.data"));
         DataOutputStream dos = new DataOutputStream(fos);
         FileInputStream fis = new FileInputStream("D:\\myData.data");
         DataInputStream dis = new DataInputStream(fis);) {
      
      dos.writeChars("JP");
      dos.writeInt(999);
      dos.writeDouble(45.8);
      dos.writeBoolean(true);
      dos.writeUTF("68% of the time works every time!");
      
      System.out.println(dis.readChar());
      System.out.println(dis.readChar());
      System.out.println(dis.readInt());
      System.out.println(dis.readDouble());
      System.out.println(dis.readBoolean());
      System.out.println(dis.readUTF());
    }
    
  }
  
}
