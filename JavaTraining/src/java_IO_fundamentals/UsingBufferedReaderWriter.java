package java_IO_fundamentals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UsingBufferedReaderWriter {
  
  public static void main(String[] args) {
    try (FileReader fr = new FileReader("D:\\myfile.txt");
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter("D:\\myfile.txt");
        BufferedWriter bw = new BufferedWriter(fw);) {

      // Read line by line of input file and write to output file.
      String line = null;
      while ((line = br.readLine()) != null) {
        bw.write(line);
        bw.newLine();
      }
    } catch (IOException e) {
      System.out.println(e);
    }
  }
  
}
