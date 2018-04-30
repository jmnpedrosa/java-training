package assertions;

/**
 * Example of code containing instructions that
 * ARE reachable, even if unintentionally.
 * This is a candidate for placing an assertion.
 */

public class AssertingBlocksReach {
  
	void unreachableStatement() {
		int a = (int)(Math.random() * 4) + 1;
		if (a >= 2)
			return;
		else if (a < 2)
			return;
		System.out.println("should not reach here");
	}
	
}
