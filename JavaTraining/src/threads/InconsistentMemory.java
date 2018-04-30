package threads;

/*
 * Example of how threads that access shared objects can report inconsistent memory.
 * Class DataReader will either read 1 or 0 depending on whether it executes before
 * or after DataIncrementer (even though it is called after).
 */

class Data {
  private int items = 0;
  
  public void increment() {
    ++items;
  }
  
  public int read() {
    return items;
  }
}

class DataIncrementer extends Thread {
  private Data data;
  
  public DataIncrementer(Data data) {
    this.data = data;
  }
  
  public void run() {
    data.increment();
  }
}

class DataReader extends Thread {
  private Data data;
  
  public DataReader(Data data) {
    this.data = data;
  }
  
  public void run() {
    System.out.println(data.read());
  }
}

public class InconsistentMemory {
  
  public static void main(String args[]) throws Exception {
    Data data = new Data();
    Thread di = new DataIncrementer(data);
    Thread dr = new DataReader(data);
    di.start();
    dr.start();
  }
  
}
