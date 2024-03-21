package mediator;

import java.util.ArrayList;
import java.util.List;

interface MyControlTower {			// Mediator
	void requestToLand(MyAircraft aircraft);
	void handleAircraftRequests();
}

class MyAirTrafficController implements MyControlTower {		// Concrete Mediator
	private List<MyAircraft> queuedForLanding = new ArrayList<>();

	@Override
	public void requestToLand(MyAircraft aircraft) {
		queuedForLanding.add(aircraft);
	}
	@Override
	public void handleAircraftRequests() {
		for(MyAircraft aircraft : queuedForLanding) {
			System.out.println("Checking possibilities for... "+ aircraft + " landing");
			aircraft.land();
		}
	}
}

interface MyAircraft {			//Colleague
	void requestForLanding();
	void land();
}

class MyF16 implements MyAircraft {			//ConcreteCollegue1
	
	private MyControlTower controlTower;

	public MyF16(MyControlTower controlTower) {
		this.controlTower = controlTower;
	}

	@Override
	public void land() {
		System.out.println("F16 is landing...");
	}
	
	public void requestForLanding() {
		controlTower.requestToLand(this);
	}
	
}

class MyBoeing747 implements MyAircraft {		//ConcreteCollegue2

	private MyControlTower controlTower;
	
	public MyBoeing747(MyControlTower controlTower) {
		this.controlTower = controlTower;
	}

	@Override
	public void land() {
		System.out.println("Boeing747 is landing...");
	}
	
	public void requestForLanding() {
		controlTower.requestToLand(this);
	}
	
}

public class MyTestMediatorPattern {

	public static void main(String[] args) {
		
		MyControlTower controlTower = new MyAirTrafficController();
		
		MyAircraft f16 = new MyF16(controlTower);
		MyAircraft boe747 = new MyBoeing747(controlTower);
		
		f16.requestForLanding();
		boe747.requestForLanding();
		
		controlTower.handleAircraftRequests();
		
	}

}
