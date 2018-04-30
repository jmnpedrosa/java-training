package threads;

import java.util.Set;

/*
 * A utility method to retrieve all the currently running threads
 * and their state.
 */

public class ShowThreads {
	public static void main(String... args) {
		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
		for(Thread t : threadSet)
			System.out.println(t + " --- " + t.getState());
	}
}