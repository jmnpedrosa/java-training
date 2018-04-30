package innerclasses;

/*
 * Examples of how anonymous inner classes can be used to succinctly
 * override a certain method and how they can be passed on to methods as
 * arguments.
 * 
 * Also shown are examples of local method classes (inner classes defined 
 * inside methods) and how they behave.
 */

class Pen {
  public void write() {
    System.out.println("Pen-write");
  }
}

class AnonymousAndMethodClasses {
  Pen pen = new Pen();
  
  Pen pen1 = new Pen() {
    @Override
    public void write() {
      System.out.println("Writing with a pen");
    }
  };
  
  Pen pen2 = new Pen() {};
  
  public void notes(Pen pen) {
    pen.write();
  }
  
  
}

class Student {
  void attendLecture() {
    AnonymousAndMethodClasses lecture = new AnonymousAndMethodClasses();
    lecture.notes(new Pen() {
      @Override
      public void write() {
        System.out.println("Okay! I am writing");
      }
    });
  }
}

// You can use an anonymous inner class to return a value from a method
class Outers {
  Object foo() {
    return new Object() {
      @Override
      public String toString() {
        return "Anonymous";
      }
    };
  }
}

interface Flyable {
  void fly();
}
class BirdSanctuary {
  Flyable bird = new Flyable(){
    @Override
    public void fly() {
      System.out.println("Flying high in the sky");
    }
    
    public void hungry() {
      System.out.println("eat");
    }
  };
}

class Pizza{
  Object margarita() {
    String ingredient = "Cheese";
    return new Pizza() {
      public String toString() {
        System.out.println(ingredient); // Won't compile in Java 7
        return "margarita";
      }
    };
  }
}

class Outers1 {
  void outerMethod () {
    /*
     * When a class is defined inside a method,
     * it can inly be referenced after its definition.
     */
    //Inner in1 = new Inner(); // Won't compile.
    class Inner {}
    Inner inner = new Inner();
  }
}

class Outers2 {
  private int privateOuter = 10;
  void outerMethod () {
    class Inner {
      protected Inner() {}
      public int publicInner = 100;
      // Inner method class field from outer class
      int privateInner = Outers2.this.privateOuter;
    }
  }
}