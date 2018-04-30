package string_processing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * You can use classes Patter and Matcher to search for occurrences
 * of a pattern of characters in a String, resolved against a regex pattern.
 * 
 * The Matcher object has a replaceAll() method to replace all
 * found occurrences of the regex pattern with the specified String.
 */

public class UsingPatternMatcher2 {
  
	public static void main(String[] args) {
	  
		String targetString = "A b$9;";
		String regex = "\\W";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(targetString);
		
		// Replace all occurrences found by the matcher
		String replacedStr = matcher.replaceAll("[]");
		System.out.println(replacedStr);
	}
}