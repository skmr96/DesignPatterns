package adapter;

// https://www.youtube.com/watch?v=5-xqFjo_jC8
// https://www.vogella.com/tutorials/DesignPatternAdapter/article.html

// I have a device brought from US

interface IndianPlug {				
	int getINCurrent();
}

interface USPlug {				// Target								// IAircraft - fly()
	int getUSCurrent();
}

class USSocket implements USPlug {											// Aircraft - fly()

	@Override
	public int getUSCurrent() {
		return 120;
	}
}

class IndianSocket implements IndianPlug {			// Adaptee			// HotAirBalloon - fly()

	@Override
	public int getINCurrent() {
		return 240;
	}
}

class INToUSPowerAdapter implements USPlug {  		// Adapter  			// Adapter - fly()

	private IndianPlug indianPlug;							// HotAirBalloon
	
	INToUSPowerAdapter(IndianPlug indianPlug) {
		this.indianPlug = indianPlug;
		System.out.println("Plugged-in in to the Adapter");
	}
	
	@Override
	public int getUSCurrent() {
		int ic = indianPlug.getINCurrent();
		return ic/2 ;								// Converting to US Current
	}
	
}

public class TestAdapterPattern {

	public static void main(String[] args) {
		
		USPlug usPlug = new USSocket();
		int usv = usPlug.getUSCurrent();
		System.out.println(usv + "V");
		
		IndianPlug indianPlug = new IndianSocket();
		
		usPlug  = new INToUSPowerAdapter(indianPlug);  		// Object Adapter
		usv = usPlug.getUSCurrent();
		
		System.out.println(usv + "V");
		
	}

}


/// Wrongly Understood 

//interface IndianPlug {				// Target
//	void supplyINCurrent();
//}
//
//interface USPlug {
//	void supplyUSCurrent();
//}
//
//class IndianSocket implements IndianPlug {
//
//	@Override
//	public void supplyINCurrent() {
//		System.out.println("Supplying IN Current of 240V...");
//	}
//}
//
//class USSocket implements USPlug {			// Adaptee
//
//	@Override
//	public void supplyUSCurrent() {
//		System.out.println("Supplying US Current of 120V...");
//	}
//}
//
//class USToINPowerAdapter implements IndianPlug {  // Adapter //  class USToINPowerAdapter  extends USSocket implements IndianPlug { // class Adapter 
//
//	private USPlug usPlug;					
//	
//	USToINPowerAdapter(USPlug usPlug) {
//		this.usPlug = usPlug;
//		System.out.println("Plugged-in in to the Adapter");
//	}
//	
//	@Override
//	public void supplyINCurrent() {
//		usPlug.supplyUSCurrent();
//	}
//	
//}