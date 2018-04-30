package string_processing;

import java.util.Scanner;

/*
 * You can use a Scanner object to read primitive data types or pieces
 * of text from a larger String of text.
 */

public class UsingScanner {
  
	public static void main(String[] args) {
	  
		String in = "1 this 10 is 100 sparta 1000";
		Scanner s = new Scanner(in);
		int sum = 0;
		String text = "";
		
		for(int x = 0; x < 7; x++) {
		  // if next readable token from input is an int, read as an int
		  if (s.hasNextInt())
			sum += s.nextInt();
		  // if there is another readable token in the input, read it
		  else if (s.hasNext())
		    text += s.next();
		}
		
		System.out.println(sum);
		System.out.println(text);
		s.close();
		
	}
}