package factory;

interface F16 {				// Product
	void create();
}

class F16A implements F16 {		// Concrete Product
	
	@Override
	public void create() {
		System.out.println(" Creating F16A Aircraft..");
	}	
}

class F16B implements F16 {
	
	@Override
	public void create() {
		System.out.println(" Creating F16B Aircraft..");
	}	
}

abstract class F16Aircraft {		// Creator

	abstract F16 getAircraftInstance(); // factory Method

	public void createAircraft() {
		F16 f16 = getAircraftInstance();
		f16.create();
		System.out.println("Your Aircraft  is ready to fly");
	}

}

class F16AAircraft extends F16Aircraft {		// Concrete Creator

	@Override
	F16 getAircraftInstance() {	
		return new F16A();
	}
}

class F16BAircraft extends F16Aircraft {

	@Override
	F16 getAircraftInstance() {
		return new F16B();
	}
}

public class MyTestFactoryPattern {

	public static void main(String[] args) {
		
		F16Aircraft f16A =  new F16AAircraft();
		f16A.createAircraft();
		
		F16Aircraft f16B = new F16BAircraft();
		f16B.createAircraft();

	}
}

///____________________________________________________
//F16Aircraft f16A =  F16Type.F16A.getInstance();
//f16A.createAircraft();
//
//F16Aircraft f16B = F16Type.F16A.getInstance();
//f16B.createAircraft();

//enum F16Type {
//	
//	F16A (new F16AFactory("F16A")), F16B(new F16BFactory("F16B"));
//	
//	private F16Aircraft f16Factory;
//	
//	F16Type(F16Aircraft f16aFactory) {
//		this.f16Factory = f16aFactory;
//	}
//
//	public F16Aircraft getInstance() {
//		return f16Factory;
//	}
//}
