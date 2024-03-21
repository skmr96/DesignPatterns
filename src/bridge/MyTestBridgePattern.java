package bridge;

import java.util.Arrays;
import java.util.List;

interface MyCarSecurityProduct {			// Implementor
	String productName();
	void produce();	
}

abstract class MyCar {				// Abstraction
	
	protected List<MyCarSecurityProduct> carSecurityProducts;
	protected String carType;
	
	public MyCar(List<MyCarSecurityProduct> carSecurityProducts, String carType) {
		this.carSecurityProducts = carSecurityProducts;
		this.carType = carType;
	}
	
	abstract void addToTheCar();
	abstract void produceProduct();	
}

class MyBMW extends MyCar {			// Refined Abstraction

	public MyBMW(List<MyCarSecurityProduct> carSecurityProducts, String carType) {
		super(carSecurityProducts, carType);
	}

	@Override
	void addToTheCar() {
		for(MyCarSecurityProduct myCarSecurityProduct : carSecurityProducts)
			System.out.println("Adding "+ myCarSecurityProduct.productName() + " system to the car "+ carType);
	}

	@Override
	void produceProduct() {
		for(MyCarSecurityProduct myCarSecurityProduct : carSecurityProducts)
			myCarSecurityProduct.produce();
	}				
	
}

class MyAudi extends MyCar {		// Refined Abstraction

	public MyAudi(List<MyCarSecurityProduct> carSecurityProduct, String carType) {
		super(carSecurityProduct, carType);
	}
	
	@Override
	void addToTheCar() {
		for(MyCarSecurityProduct myCarSecurityProduct : carSecurityProducts)
			System.out.println("Adding "+ myCarSecurityProduct.productName() + " system to the car "+ carType);
	}

	@Override
	void produceProduct() {
		for(MyCarSecurityProduct myCarSecurityProduct : carSecurityProducts)
			myCarSecurityProduct.produce();
	}
	
}

class MyCentralLocking implements MyCarSecurityProduct {	// ConcreteImplementor1

	private String productName;
	
	public MyCentralLocking(String productName) {
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

class MyGearLocking implements MyCarSecurityProduct {	// ConcreteImplementor2

	private String productName;
	
	public MyGearLocking(String productName) {
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

public class MyTestBridgePattern {

	public static void main(String[] args) {
		
		MyCarSecurityProduct centralLock = new MyCentralLocking("Central Locking");  // Implementor
		MyCarSecurityProduct gearLock = new MyGearLocking("Gear Locking");
		
		MyCar car = new MyBMW(Arrays.asList(centralLock,gearLock), "BMW");				// Can also pass List of Implementors. I think so
		car.produceProduct();
		car.addToTheCar();
		
		car = new MyAudi(Arrays.asList(centralLock), "Audi");
		car.produceProduct();
		car.addToTheCar();

	}

}
