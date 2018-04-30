package concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/*
 * A demonstration of the "fork-join" implementation of Java.
 * 
 * CalcSum is a RecursiveTask that computes an integer value.
 */

public class CalcSum extends RecursiveTask<Integer> {
  
  private static final long serialVersionUID = 1L;
  private int UNIT_SIZE = 15;
  private int[] values;
  private int startPos;
  private int endPos;

  public CalcSum(int[] values) {
    this(values, 0, values.length);
  }

  public CalcSum(int[] values, int startPos, int endPos) {
    this.values = values;
    this.startPos = startPos;
    this.endPos = endPos;
  }

  // For CalcSum, overridden method compute() returns an integer value.
  @Override
  protected Integer compute() {
    
    final int currentSize = endPos - startPos;
    
    if (currentSize <= UNIT_SIZE) {
      return computeSum();
    } else {
      int center = currentSize / 2;
      int leftEnd = startPos + center;
      CalcSum leftSum = new CalcSum(values, startPos, leftEnd);
      
      // Calling fork on leftSum executes it asynchronously.
      leftSum.fork(); 

      int rightStart = startPos + center+1;
      CalcSum rightSum = new CalcSum(values, rightStart, endPos);
      
      // leftSum.join() waits until it returns a value.
      // rightSum.compute() is main computation performed by task.
      return(rightSum.compute() + leftSum.join());
    }
    
  }

  // Private helper method.
  private Integer computeSum() {
    
    int sum = 0;
    for (int i = startPos; i < endPos; i++) {
      sum += values[i];
    }
    System.out.println("Sum(" + startPos + "-" + endPos + "):" + sum);
    return sum;
    
  }

  public static void main(String... args) {
    
    // Create an array of 500 random integers.
    int[] intArray = new int[500];
    java.util.Random randomValues = new java.util.Random();

    for (int i = 0; i < intArray.length; i++) {
      intArray[i] = randomValues.nextInt(10);
    }
    
    // Create a ForkJoinPool to calculate the 
    // sum of every integer
    ForkJoinPool pool = new ForkJoinPool();
    CalcSum calculator = new CalcSum(intArray);
    
    // invoke() awaits and obtains result
    System.out.println(pool.invoke(calculator));
  }
  
}
