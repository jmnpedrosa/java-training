package string_processing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * You can use classes Patter and Matcher to search for occurrences
 * of a pattern of characters in a String, resolved against a regex pattern.
 * 
 * The Matcher object provides various information about each occurrence.
 */

public class UsingPatternMatcher {
  
	public static void main(String[] args) {
	  
		String targetString = "I am fine to dine at nine";
		String regex = "[fdn]ine";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(targetString);
		
		// Will search for next occurrence and return "true" if found.
		while (matcher.find()) {
		  // Print the occurrence found and additional info.
			System.out.println(matcher.group() + " starts at " +
							   matcher.start() + ", ends at " +
							   matcher.end());
		}
	}
}
