package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Using ReentrantLock objects can help you avoid situations of 
 * "deadlock", as shown in the example below.
 */

class Inventory {
  
  int inStock; String name;
  
  Lock lock = new ReentrantLock();
  
  Inventory(String name) { this.name = name; }
  
  public void stockIn(long qty) { inStock += qty; }
  public void stockOut(long qty) { inStock -= qty; }
  
}

public class Shipment extends Thread {
  
  Inventory loc1, loc2; int qty;
  
  Shipment(Inventory loc1, Inventory loc2, int qty) {
    this.loc1 = loc1;
    this.loc2 = loc2;
    this.qty = qty;
  }
  
//  @Override
//  public void run() {
//    //This code might cause deadlock
//    synchronized(loc1) {
//      synchronized(loc2) {
//        loc2.stockOut(qty);
//        loc1.stockIn(qty);
//        System.out.println(loc1.inStock + ":" + loc2.inStock);
//      }
//    }
//  }
  
  @Override
  public void run() {
    //This code fixes the deadlock issue
   if (loc1.lock.tryLock()) {
     if (loc2.lock.tryLock()) {
        loc2.stockOut(qty);
        loc1.stockIn(qty);
        System.out.println(loc1.inStock + ":" + loc2.inStock);
        loc2.lock.unlock();
        loc1.lock.unlock();
      } else System.out.println("locking false: " + loc2.name);
    } else System.out.println("locking false: " + loc1.name);
  }
  
  public static void main(String args[]) {
    Inventory loc1 = new Inventory("Lisboa"); loc1.inStock = 100;
    Inventory loc2 = new Inventory("Porto"); loc2.inStock = 200;
    Shipment s1 = new Shipment(loc1, loc2, 1);
    Shipment s2 = new Shipment(loc2, loc1, 10);
    s1.start();
    s2.start();
  }
  
}
