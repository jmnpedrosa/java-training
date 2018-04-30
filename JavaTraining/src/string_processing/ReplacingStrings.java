package string_processing;

/*
 * Because String objects are immutable, you can only manipulate them
 * by creating new Strings with the modified content, like methods
 * substring() and replaceAll() do.
 */

public class ReplacingStrings {
  
	public static void main(String[] args) {
		String str = "cat cup copp";
		
		// Replaces all occurrences of the specified regex with "()"
		// and returns a new string. Original string is not modified.
		String newString = str.replaceAll("c.p\\b", "()");
		System.out.println(newString);
		
		// Returns true is string starts with the specified substring
		// at the given index, and false if not, or the given index is
		// invalid.
		String str1 = "Start startup, time to start";
		System.out.println(str1.startsWith("Start"));
		System.out.println(str1.startsWith("Start", 0));
		System.out.println(str1.startsWith("Start", -1));
		System.out.println(str1.startsWith("Start", 1));
		
		// Compares Strings lexicographically
		String a = "a";
		String b = "A";
		System.out.println(a.compareTo(b));
		System.out.println(b.compareTo(a));
		
		// Because each method returns a new String, you can chain them together
		String str2 = "Start startup, time to start";
		System.out.println(str2.substring(0,1).compareTo(str2.substring(6,7)));
		
	}
}
