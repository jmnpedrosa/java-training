package class_design;

/**
 * Example of proper hashCode() implementation.
 */
class MyNumber {
  
  long number;
  
  MyNumber(long number) { 
    this.number = number;
  }
  
  /**
   * this hashCode() returns a sum of all the 
   * individual digits of the 'number' field.
   */
  @Override
  public int hashCode() {
    int sum = 0;
    long num = number;
    do {
      sum += num % 10; num /= 10;
    } while (num != 0);
    return sum;
  }
  
  @Override
  public boolean equals(Object o) {
    if (o != null && o instanceof MyNumber)
      return (number == ((MyNumber) o).number);
    else
      return false;
  }
  
  public static void main(String[] args) {
    MyNumber n1 = new MyNumber(9);
    MyNumber n2 = new MyNumber(18);
    MyNumber n3 = new MyNumber(18);
    System.out.println(n1.equals(n2) + ":" + n1.hashCode() + ":" + n2.hashCode());
    System.out.println(n2.equals(n3) + ":" + n2.hashCode() + ":" + n3.hashCode());
  }
}
