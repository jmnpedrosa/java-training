package class_design;

/*
 * Example of an equals() method that
 * violates symmetric and reflexive rules
 */

class MyString {
  
  String value;
  
  MyString(String value) {
    this.value = value;
  }
  
  @Override
  public boolean equals(Object o) {
    return (value.equals(o));
  }
  
}

class BadEqualsMethod {
  
  public static void main(String... args) {
    MyString s1 = new MyString("string1");
    String s2 = "string1";
    System.out.println(s1.equals(s2));
    System.out.println(s2.equals(s1));
    System.out.println(s1.equals(s1));
  }
  
}
