package facade;

//Route - inputRoute()
//Translator - translateToFlightPlan()
//updateInDB - loadPlanToDB()

class AltitudeMonitor {
	void autoMonitor() {}
	void turnOff() {}
}

class EngineController {
	void setEngineSpeed() {}
	void turnOff() {}
}

class NavigationSystem {
	void setDirection() {}
	void turnOff() {}
}

class Airplane {			// Facade  -  Collection of Subsystems
	
	private AltitudeMonitor altitudeMonitor;
	private EngineController engineController;
	private NavigationSystem navigationSystem;
	
	public Airplane(AltitudeMonitor altitudeMonitor, EngineController engineController,
			NavigationSystem navigationSystem) {
		this.altitudeMonitor = altitudeMonitor;
		this.engineController = engineController;
		this.navigationSystem = navigationSystem;
	}
	
	public void enableAutoPilot() {
		altitudeMonitor.autoMonitor();
		engineController.setEngineSpeed();
		navigationSystem.setDirection();
	}
	
	public void disableAutoPilot() {
		altitudeMonitor.turnOff();
		engineController.turnOff();
		navigationSystem.turnOff();
	}
}

public class TestFacadePattern {

	public static void main(String[] args) {
		
		AltitudeMonitor altitudeMonitor = new AltitudeMonitor();
		EngineController engineController = new EngineController();
		NavigationSystem navigationSystem = new NavigationSystem();
		
		Airplane plane = new Airplane(altitudeMonitor, engineController, navigationSystem);
		plane.enableAutoPilot();
		plane.disableAutoPilot();

	}

}


//private AltitudeMonitor altitudeMonitor;
//private EngineController engineController;
//private FuelMonitor fuelMonitor;
//private NavigationSystem navigationSystem;