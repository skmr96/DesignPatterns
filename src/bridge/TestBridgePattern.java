package bridge;

interface CarSecurityProduct {			// Implementor
	String productName();
	void produce();	
}

abstract class Car {				// Abstraction			// Corolla
	
	protected CarSecurityProduct carSecurityProduct;
	protected String carType;
	
	public Car(CarSecurityProduct carSecurityProduct, String carType) {
		this.carSecurityProduct = carSecurityProduct;
		this.carType = carType;
	}
	
	abstract void produceSecurityProduct();	
	abstract void addSecurityProductToTheCar();
}

class BMW extends Car {			// Refined Abstraction

	public BMW(CarSecurityProduct carSecurityProduct, String carType) {
		super(carSecurityProduct, carType);
	}

	@Override
	void addSecurityProductToTheCar() {
		System.out.println("Adding "+ carSecurityProduct.productName() + " system to the car "+ carType);
	}

	@Override
	void produceSecurityProduct() {
		carSecurityProduct.produce();
	}				
	
}

class Audi extends Car {		// Refined Abstraction

	public Audi(CarSecurityProduct carSecurityProduct, String carType) {
		super(carSecurityProduct, carType);
	}
	
	@Override
	void addSecurityProductToTheCar() {
		System.out.println("Adding "+ carSecurityProduct.productName() + " system to the car "+ carType);
	}

	@Override
	void produceSecurityProduct() {
		carSecurityProduct.produce();
	}
	
}

class CentralLocking implements CarSecurityProduct {	// ConcreteImplementor1

	private String productName;
	
	public CentralLocking(String productName) {
		this.productName = productName;
	}

	@Override
	public String productName() {
		return productName;
	}

	@Override
	public void produce() {
		System.out.println("Producing Central Locking System...");
	}	
	
}

class GearLocking implements CarSecurityProduct {	// ConcreteImplementor2

	private String productName;
	
	public GearLocking(String productName) {
		this.productName = productName;
	}
	
	@Override
	public String productName() {
		return productName;
	}

	@Override
	public void produce() {
		System.out.println("Producing Gear Locking System...");
	}	
	
}

public class TestBridgePattern {

	public static void main(String[] args) {
		
		CarSecurityProduct centralLock = new CentralLocking("Central Locking");  // Implementor
		CarSecurityProduct gearLock = new GearLocking("Gear Locking");
		
		Car car = new BMW(centralLock, "BMW");				// Can also pass List of Implementors. I think so
		car.produceSecurityProduct();
		car.addSecurityProductToTheCar();
		
		car = new BMW(gearLock, "BMW");
		car.produceSecurityProduct();
		car.addSecurityProductToTheCar();
		
		car = new Audi(centralLock, "Audi");
		car.produceSecurityProduct();
		car.addSecurityProductToTheCar();

	}

}
