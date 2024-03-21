  package abstractfactory;

interface IEngine { 	// Abstract Product A
	void create();
}

interface IWings {
	void create();
}

interface ICockpit {
	void create();
}

interface IAircraftFactory {	// Abstract Factory
	IEngine getEngineInstance();
	IWings getWingsInstance();
	ICockpit getCockpitInstance();
}

class F16Factory implements IAircraftFactory {		//Concrete Factory A
	
	@Override
	public IEngine getEngineInstance() {	
		return new F16Engine();
	}

	@Override
	public IWings getWingsInstance() {
		return new F16Wings();
	}

	@Override
	public ICockpit getCockpitInstance() {
		return new F16Cockpit();
	}
}

class Boeing747Factory implements IAircraftFactory {	//Concrete Factory B
	
	@Override
	public IEngine getEngineInstance() {	
		return new Boeing747Engine();
	}

	@Override
	public IWings getWingsInstance() {
		return new Boeing747Wings();
	}

	@Override
	public ICockpit getCockpitInstance() {
		return new Boeing747Cockpit();
	}
}

class F16Engine implements IEngine {		// Concrete Product A1

	@Override
	public void create() {
		System.out.println("Creating F16 Engine...");
	}
}

class F16Cockpit implements ICockpit {

	@Override
	public void create() {
		System.out.println("Creating F16 Cockpit...");
	}	
}

class F16Wings implements IWings {

	@Override
	public void create() {
		System.out.println("Creating F16 Wings...");
	}	
}

class Boeing747Engine implements IEngine {		// Concrete Product A2

	@Override
	public void create() {
		System.out.println("Creating Boeing747 Engine...");
	}	
}

class Boeing747Cockpit implements ICockpit {

	@Override
	public void create() {
		System.out.println("Creating Boeing747 Cockpit...");
	}
} 

class Boeing747Wings implements IWings {

	@Override
	public void create() {
		System.out.println("Creating Boeing747 Wings...");
	}
	
}

 enum AirplaneType {
	F16(new F16Factory()), BOEING747(new Boeing747Factory());
	
	private IAircraftFactory factoryType;
	
	AirplaneType(IAircraftFactory factory) {
		this.factoryType = factory;
	}
	
	public IAircraftFactory getFactory() {
		return factoryType;
	}
}

class Airplane {
	
	private IEngine engine;
	private IWings wings;
	private ICockpit cockpit;
	private AirplaneType type;
	private IAircraftFactory factory;
	
	public Airplane(AirplaneType type) {
		this.type = type;
		this.factory = type.getFactory();
	}
	
	private void createEngine() {
		engine = factory.getEngineInstance();
		engine.create();
	}
	
	private void createWings() {
		wings = factory.getWingsInstance();
		wings.create();
	}
	
	private void createCockpit() {
		cockpit = factory.getCockpitInstance();
		cockpit.create();
	}
	
	public void createAircraft() {
		createEngine();
		createWings();
		createCockpit();
		System.out.println("Your Aircraft " + type + " is ready to fly");
	}
}

public class TestAbstractFactoryPattern {

	public static void main(String[] args) {
		
//		Airplane f16Aircraft = new Airplane(AirplaneType.F16);
//		f16Aircraft.createAircraft();
//		
//		Airplane boeing747Aircraft = new Airplane(AirplaneType.BOEING747);
//		boeing747Aircraft.createAircraft();
		
		IAircraftFactory f16Factory = new F16Factory();
		IEngine engine = f16Factory.getEngineInstance();
		engine.create();
		IWings wings = f16Factory.getWingsInstance();
		wings.create();
		ICockpit cockpit = f16Factory.getCockpitInstance();
		cockpit.create();
		
		IAircraftFactory boeingFactory = new Boeing747Factory();
		engine = boeingFactory.getEngineInstance();
		engine.create();
		wings = boeingFactory.getWingsInstance();
		wings.create();
		cockpit = boeingFactory.getCockpitInstance();
		cockpit.create();

	}

}
