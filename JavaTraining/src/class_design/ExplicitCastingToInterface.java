package class_design;

/*
 * You can explicitly cast any class into a certain interface
 * at the code will compile, even if the class has no IS-A
 * relationship with said interface (this will, however, throw
 * a ClassCastException at runtime.)
 */

interface Scavenger{}
class Bird{}
class Parrot extends Bird{}
class Vulture extends Bird implements Scavenger{}

class ExplicitCastingToInterface {
  
  public static void main(String args[]) {
    
    Bird bird = new Bird();
    Parrot parrot = new Parrot();
    Vulture vulture = new Vulture();
//    Scavenger sc2 = bird; // Won't compile
    Scavenger sc2 = (Scavenger) bird; // compiles, but throws ClassCastException
    
  }
  
}
