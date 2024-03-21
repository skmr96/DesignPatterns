package decorator;

abstract class Pizza { 				// Component
	
	protected String desc; 
	
	public String getDesc() {
		return desc;
	}
	abstract public int getPrice();
}

class Margherita extends Pizza {	// Concrete Component

	public Margherita() {
		desc = "Margherita..";
	}
	
	@Override
	public int getPrice() {
		return 99;
	}
	
}

class PeppyPaneer extends Pizza {

	public PeppyPaneer() {
		desc = "PeppyPaneer..";
	}
	
	@Override
	public int getPrice() {
		return 109;
	}
}

abstract class PizzaToppings extends Pizza {		// Decorator
	
	public abstract String getDesc();
}

class Paneer extends PizzaToppings {		// Concrete Decorator
	
	private Pizza pizza;
	
	Paneer(Pizza pizza) {
		this.pizza = pizza;
	}
	
	public String getDesc() {
		return this.pizza.getDesc() + " Adding Panner...";
	}
	@Override
	public int getPrice() {
		return this.pizza.getPrice()+50;
	}
}

class Onion extends PizzaToppings {
	
	private Pizza pizza;
	
	Onion(Pizza pizza) {
		this.pizza = pizza;
	}
	
	public String getDesc() {
		return this.pizza.getDesc() + " Adding Onion...";
	}
	@Override
	public int getPrice() {
		return this.pizza.getPrice()+70;
	}
}

class Cheese extends PizzaToppings {
	
	private Pizza pizza;

	Cheese(Pizza pizza) {
		this.pizza = pizza;
	}
	
	public String getDesc() {
		return this.pizza.getDesc() + " Adding Cheese...";
	}
	@Override
	public int getPrice() {
		return this.pizza.getPrice()+40;
	}
}

public class TestDecoratorPattern {

	public static void main(String[] args) {
		
		Pizza pizza = new Margherita();
		
		pizza = new Cheese(pizza);
		pizza = new Onion(pizza);
		pizza = new Paneer(pizza);
		
		System.out.println(pizza.getDesc());
		System.out.println(pizza.getPrice());
		
		

	}

}
