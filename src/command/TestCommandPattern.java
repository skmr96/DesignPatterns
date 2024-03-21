package command;

import java.util.ArrayList;
import java.util.List;

interface Command {					// Command
	void execute();
}

class LandingGear {				// Receiver
	void up() {
		System.out.println("Landing Gear Up..");
	}
	void down() {
		System.out.println("Landing Gear Down..");
	}
}

class LandingGearUpCommand implements Command {				//ConcreteCommand1
	private LandingGear landingGear;
	
	public LandingGearUpCommand(LandingGear landingGear) {
		this.landingGear = landingGear;
	}

	@Override
	public void execute() {
		landingGear.up();							//receiver.action()
	}
}

class LandingGearDownCommand implements Command {			//ConcreteCommand2
	private LandingGear landingGear;
	
	public LandingGearDownCommand(LandingGear landingGear) {
		this.landingGear = landingGear;
	}
	
	@Override
	public void execute() {
		landingGear.down();	
	}
}

class InstrumentPanel {				//Invoker
	private List<Command> commands = new ArrayList<>();
	
	void setCommand(int index, Command command) {
		commands.add(index,command);
	}
	
	void upLandGear() {
		commands.get(0).execute();
	}
	
	void lowLandGear() {
		commands.get(1).execute();
	}
}

public class TestCommandPattern {					//Client

	public static void main(String[] args) {
		
		LandingGear landingGear = new LandingGear();
		LandingGearUpCommand lu = new LandingGearUpCommand(landingGear);
		LandingGearDownCommand ld = new LandingGearDownCommand(landingGear);
		
		InstrumentPanel ip = new InstrumentPanel();
		ip.setCommand(0,lu);
		ip.setCommand(1,ld);
		
		ip.upLandGear();
		ip.lowLandGear();

	}

}
