package class_design;

/**
 *  In this example, the compiler rearranges the code for execution.
 *  
 *  First it declares the static variable age.
 *  Second picks the variable assignments in each initializer 
 *  block and combines them in a single block, in the order
 *	of their occurrence, as follows:
 *	
 *	static int rate;
 *	static
 *	{
 *		rate = 10;
 *		rate = 0;
 *		++rate;
 *	}
 *
 *	This is why StaticVariableShenanigans prints 1 and not 11.
 */

public class StaticVariableShenanigans {
  
	static {
		rate = 10;
	}
	
	static int rate = 0;
	
	static {
		++rate;
	}
	
	public StaticVariableShenanigans() {
		System.out.println(rate);
	}
	
	public static void main(String args[]) {
		new StaticVariableShenanigans();
	}
	
}