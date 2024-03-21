package abstractfactory;

interface IAircraft { 	// Abstract Product 
	void create();
}

class F16Aircraft implements IAircraft {		// Concrete Product A

	@Override
	public void create() {
		System.out.println("Creating F16 Aircraft...");
	}
}

class Boeing747Aircraft implements IAircraft {		// Concrete Product B

	@Override
	public void create() {
		System.out.println("Creating Boeing747 Aircraft...");
	}	
}

interface AircraftFactory {	// Abstract Factory
	IAircraft getAircraftInstance();
}

class F16AircraftFactory implements AircraftFactory {		//Concrete Factory A
	
	@Override
	public IAircraft getAircraftInstance() {	
		return new F16Aircraft();
	}
}

class Boeing747AircraftFactory implements AircraftFactory {		//Concrete Factory B
	
	@Override
	public IAircraft getAircraftInstance() {	
		return new Boeing747Aircraft();
	}
}

enum AircraftType {
	F16(new F16AircraftFactory()), BOEING747(new Boeing747AircraftFactory());
	
	private AircraftFactory factoryType;
	
	AircraftType(AircraftFactory factory) {
		this.factoryType = factory;
	}
	
	public AircraftFactory getFactory() {
		return factoryType;
	}
}

class Aircraft {			// Client
	
	private IAircraft aircraft;
	private AircraftType type;
	private AircraftFactory factory;
	
	public Aircraft(AircraftType type) {
		this.type = type;
		this.factory = type.getFactory();
	}
	
	public void createAircraft() {
		aircraft = factory.getAircraftInstance();
		aircraft.create();
		System.out.println("Your Aircraft " + type + " is ready to fly");
	}
}

public class MyTestAbstractFactoryPattern {

	public static void main(String[] args) {
		
		Aircraft f16Aircraft = new Aircraft(AircraftType.F16);
		f16Aircraft.createAircraft();
		
		Aircraft boeing747Aircraft = new Aircraft(AircraftType.BOEING747);
		boeing747Aircraft.createAircraft();
	}

}
