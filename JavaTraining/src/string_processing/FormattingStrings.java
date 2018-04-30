package string_processing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;

/*
 * Examples of how string formatters can be used to modify
 * different text or numeric values.
 */

public class FormattingStrings {
  
	public static void main(String[] args) throws FileNotFoundException {
		String name = "Timmy";
		
		Formatter formatter = new Formatter(new File("data.txt"));
		// Prints the "name"
		formatter.format("My name is %s", name);
		formatter.flush();
		formatter.close();
		
		// Prints the "name" and adds a line break
		System.out.printf("My name is %s \n", name);
		
		// Following output printed between square brackets
		// Prints the float number as-is
		System.out.printf("[%f] \n", 12.12345);
		
		// Forces the width to 10, padding with zeros before
		System.out.printf("[%010f] \n", 12.12345);
		
		// Forces the width to 10, padding with spaces after
		System.out.printf("[%-10f] \n", 12.12345);
		
		// Forces the width to 10, padding with spaces before,
		// and only two digits of decimal precision 
		System.out.printf("[%10.2f] \n", 12.98765);
		
		// Prints with a comma-separated format
		System.out.printf("[%,f] \n", 123456789.12345);
		
		// Prints an integer as-is
		System.out.printf("[%d] \n", 12345);
		
		// Forces the width to 10, padding with zeros before
		System.out.printf("[%010d] \n", 12345);
		
		// Prints with a comma-separated format,
		// and between parenthesis is number is negative
		System.out.printf("%(,d \n", -123456789);
		
		// Prints with a comma-separated format,
        // and between parenthesis
		System.out.printf("(%,d) \n", -123456789);
		
		// System.out.printf("[%-10.2d] \n", 12345); //Throws RuntimeException
		
		Integer age = null;
		String[] skills = {"Java", "Android"};
		System.out.format("Name is %s, age is %s, skills are %s", name, age, skills);
	}
}
