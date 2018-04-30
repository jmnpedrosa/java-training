package java_IO_fundamentals;

import java.io.Console;
import java.io.IOException;

public class ReadingFromConsole {
  
	public static void main(String args[]) throws IOException {
	    // Access the system console (cmd, terminal, etc...)
		Console console = System.console();
		String name = "";
		while (name.trim().equals("")) {
			name = console.readLine("Do you like waffles?\n");
			console.printf(name);
		}
	}
	
}