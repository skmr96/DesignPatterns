package templatemethod;

abstract class PreFlightCheckList {
	
	final void runCheckList() {
		checkFuel();
		checkDoorsClosed();
		checkAirPressure();
	}
	
	final void checkFuel() {
		System.out.println("Checking Fuel Gauge..");
	}
	
	protected boolean checkDoorsClosed() {		// Hooks - CustomerNeedsCondiments()
		return true;
	}
	
	abstract void checkAirPressure();
}

class F16CheckList extends PreFlightCheckList {

	@Override
	void checkAirPressure() {
		System.out.println("Checking Air Pressure for F16..");
	}
	
}

class Boeing747CheckList extends PreFlightCheckList {

	@Override
	void checkAirPressure() {
		System.out.println("Checking Air Pressure for Boeing747..");
	}
	
	protected boolean checkDoorsClosed() {
		System.out.println("Checking Doors were locked..");
		return true;
	}
	
}

public class TestTemplateMethodPattern {

	public static void main(String[] args) {
		
		PreFlightCheckList F16 = new F16CheckList();
		F16.runCheckList();
		
		PreFlightCheckList boeing747 = new Boeing747CheckList();
		boeing747.runCheckList();
	}

}
