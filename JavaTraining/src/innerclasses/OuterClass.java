package innerclasses;

/*
 * If you define a private inner class, only the outer class has access to it.
 */
class OuterClass {
  
  String value = "outer";
  InnerClass[] inners;
  
  // Defines InnerClass accessible only by OuterClass
  private class InnerClass {
    
    public InnerClass() {
      System.out.println(value);
    }
    
    // The inner class can have fields with the same name as the outer class
    String value = "inner";
    static final int count = 3;
  }
  
  OuterClass() {
    inners = new InnerClass[2];
  }
  
  public static void main(String args[]) {
    new OuterClass();
  }
}