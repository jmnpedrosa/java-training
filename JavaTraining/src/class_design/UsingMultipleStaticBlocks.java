package class_design;

/**
 * Demonstration of how static fields should be declared
 * before static blocks manipulate them, to avoid compilation errors
 */

class UsingMultipleStaticBlocks {
  
    /*
     * This static block can assign a value to
     * "staticVar" even though it is only declared
     * after the block.
     */
  
	static {
	    // ++staticVar; // Won't compile, if placed before field declaration.
		staticVar = 1; // Surprisingly, this compiles just fine.
	}
	
	static int staticVar;
	
	static {
		++staticVar; // Compiles just fine.
	}
	
	public UsingMultipleStaticBlocks() {
		System.out.println("Constructor:" + staticVar);
	}
	
	public static void main(String args[]) {
		new UsingMultipleStaticBlocks();
	}
}