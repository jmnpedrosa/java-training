package threads;

/*
 * A Deadlock CAN happen when two threads are trying to acquire
 * a resource the other thread is holding while not releasing a resource
 * the other thread is also requesting.
 * 
 * The following example shows code that can cause a Deadlock.
 * Thread AndroidProject holds a "tester" and requests for a "dev"
 * while thread IPhoneProject holds the "dev" and requests for a "tester".
 * This causes both threads to wait forever for each other.
 */

class MobileDev {
  synchronized void fixBugs() {
    System.out.println("fixing...");
  }
  synchronized void code() {
    System.out.println("coding...");
  }
}

class Tester {
  synchronized void testAppln() {
    System.out.println("testing...");
  }
}

class AndroidProject extends Thread {
  MobileDev dev;
  Tester tester;
  
  AndroidProject(MobileDev dev, Tester t) {
    this.dev = dev;
    this.tester = t;
  }
  
  @Override
  public void run() {
    // Grab a monitor lock on the "tester"
    // other threads will have to await its release
    synchronized (tester) {
      tester.testAppln();
      dev.fixBugs();
    }
  }
}

class IPhoneProject extends Thread {
  MobileDev dev;
  Tester tester;
  
  IPhoneProject(MobileDev dev, Tester t) {
    this.dev = dev;
    this.tester = t;
  }
  
  @Override
  public void run() {
    // Grab a monitor lock on the "dev"
    // other threads will have to await its release
    synchronized (dev) {
      dev.code();
      tester.testAppln();
    }
  }
}

public class DeadLock {
  public static void main(String[] args) {
    Tester tester = new Tester();
    MobileDev mobileDev = new MobileDev();
    
    AndroidProject androidApp = new AndroidProject(mobileDev, tester);
    IPhoneProject iPhoneApp = new IPhoneProject(mobileDev, tester);
    
    androidApp.start();
    iPhoneApp.start();
  }
}
