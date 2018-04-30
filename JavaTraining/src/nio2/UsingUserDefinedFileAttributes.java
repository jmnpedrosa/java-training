package nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserDefinedFileAttributeView;

/*
 * The UserDefinedFileAttributeView allows you to specify, 
 * read and write your own custom file attributes.
 * 
 * These attributes are stored as raw bytes that you must encode 
 * and decode accordingly in your read and write implementations.
 */

public class UsingUserDefinedFileAttributes {
  
  public static void main(String[] args) throws Exception {
    Path file = Paths.get("myfile.txt");
    
    UserDefinedFileAttributeView view = Files.getFileAttributeView(file, UserDefinedFileAttributeView.class);
    
    writeAttr(view, "delete", true);
    if (readAttr(view, "delete"))
      Files.delete(file);
  }
  
  static void writeAttr(UserDefinedFileAttributeView view, String attr, boolean value) throws IOException {
    if (value)
      view.write(attr, Charset.defaultCharset().encode("true"));
    else
      view.write(attr, Charset.defaultCharset().encode("false"));
  }
  
  static boolean readAttr(UserDefinedFileAttributeView view, String attr) throws IOException {
    ByteBuffer buf = ByteBuffer.allocate(view.size(attr));
    view.read(attr, buf);
    buf.flip();
    String value = Charset.defaultCharset().decode(buf).toString();
    return value.equalsIgnoreCase("true");
  }
  
}
