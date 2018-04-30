package class_design;

/*
 * An abstract class cannot be instantiated, but can define behavior
 * for it's subclasses to inherit.
 */

abstract class Animal {
	
    /*
     *  protected fields can be directly
     *  accessed by any subclass
     */
	protected String food;
	protected double avgLife;
	
	Animal(String food, double avgLife) {
		this.food = food;
		this.avgLife = avgLife;
	}
	
	/* this method must be implemented by any subclass */
	abstract void eat();
	
	/* this method is already defined and implemented */
	void live() {
		System.out.println("Natural habitat: forest");
	}
}

class Lion extends Animal {

    /*
     * The subclass constructor calls
     * the constructor of the superclass.
     */
	Lion(String food, double avgLife) {
		super(food, avgLife);
	}

	/*
     * Method eat() of the superclass
     * is implemented here.
	 */
	@Override
	void eat() {
		System.out.println("Lion-hunt " + food);
	}
	
}

class Elephant extends Animal {

    /*
     * The subclass constructor calls
     * the constructor of the superclass.
     */
	Elephant(String food, double avgLife) {
		super(food, avgLife);
	}

	/*
     * Method eat() of the superclass
     * is implemented here.
     */
	@Override
	void eat() {
		System.out.println("Elephant-method eat");		
	}
	
	/*
     * Subclass defines additional behavior
     */
	void moveTrunk() {
		System.out.println("Elephant-method moveTrunk");
	}
}


public class UsingInheritance {
	
	public static void main(String[] args) {
		
	    /*
	     * An array of the superclass type "Animal"
	     * can store objects of any subclass of "Animal".
	     */
		Animal[] animals = new Animal[2];
		animals[0] = new Lion("Antelope", 20);
        animals[1] = new Elephant("Bananas", 60);
        
        /*
         * Methods of class "Animal" can be called by referencing
         * all objects with a variable of type "Animal".
         */
		for (Animal anAnimal : animals) {
          anAnimal.eat();
          anAnimal.live();
		}
	}
}