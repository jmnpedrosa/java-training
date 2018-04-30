package generics;

/*
 * Examples of how generics and raw types can
 * (or can't) be used together.
 */

class Taxes {}

public class Letter<T> {
  
	private T t;
	
	public void set(T t) {
		this.t = t;
	}
	
	public T get() {
		return t;
	}
	
	public <X> void deliver(X x) {
		System.out.println(x.getClass());
	}
	
	public static void main(String[] args) {
		Letter<String> letter = new Letter<>();
		letter.<Integer>deliver(new Integer(10));
		// letter.<>deliver(new Integer(10)); // Won't compile
		letter.deliver("Greetings");

		Letter letter1 = new Letter<Taxes>();
		letter1.set("Citizen");
		
		Letter letter2 = new Letter<Taxes>();
		letter2.set(new Taxes());
		// Taxes taxes = letter2.get(); // Won't compile
		
		Letter<Taxes> letter3 = new Letter();
		letter3.set(new Taxes());
		// letter3.set(new String()); // Won't compile
		Taxes taxes = letter3.get();
	}
}
