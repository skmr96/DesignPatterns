package mediator;

import java.util.ArrayList;
import java.util.List;

interface ControlTower {			// Mediator
	void requestToLand(Aircraft aircraft);
}

class AirTrafficController implements ControlTower {		// Concrete Mediator
	private List<Aircraft> queuedForLanding = new ArrayList<>();

	@Override
	public synchronized void requestToLand(Aircraft aircraft) {
		queuedForLanding.add(aircraft);
	}
	
	public void run() {
		while(true) {
			
			while(queuedForLanding.size() == 0);
			
			Aircraft aircraft;
			synchronized (this) {
				aircraft = queuedForLanding.remove(0);
			}
			aircraft.land();
		}
	}
	
}

interface Aircraft {			//Colleague
	void land();
}

class F16 implements Aircraft {			//ConcreteCollegue1
	
	private ControlTower controlTower;

	public F16(ControlTower controlTower) {
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

class Boeing747 implements Aircraft {		//ConcreteCollegue2

	private ControlTower controlTower;
	
	public Boeing747(ControlTower controlTower) {
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

public class TestMediatorPattern {

	public static void main(String[] args) {
		
		ControlTower controlTower = new AirTrafficController();
		
		F16 f16 = new F16(controlTower);
		Boeing747 boe747 = new Boeing747(controlTower);
		
		f16.requestForLanding();
		boe747.requestForLanding();
		
		((AirTrafficController) controlTower).run();
		
	}

}
