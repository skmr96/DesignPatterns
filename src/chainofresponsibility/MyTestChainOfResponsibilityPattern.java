package chainofresponsibility;

abstract class Request {	
	private int requestCode;

	Request(int requestCode) {
		this.requestCode = requestCode;
	}
	
	int getRequestCode() {
		return requestCode;
	}
}

class LowFuelRequest extends Request {

	LowFuelRequest() {
		super(1);
	}
	
}

class FireDetectedRequest extends Request {

	FireDetectedRequest() {
		super(2);
	}
	
}

abstract class MyHandler {
	
	protected MyHandler nextHandler;
	
	MyHandler(MyHandler nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	void handleRequest(Request request) {
		if(nextHandler != null) {
			nextHandler.handleRequest(request);
		}
	}
}

class LowFuelHandler extends MyHandler {

	private int requestCode = 1;
	
	LowFuelHandler(MyHandler nextHandler) {
		super(nextHandler);
	}
	
	void handleRequest(Request request) {
		if(request.getRequestCode() == requestCode) {
			System.out.println("Low Fuel Handler...");
		}else {
			nextHandler.handleRequest(request);
		}	
	}
}

class FireHandler extends MyHandler {

	private int requestCode = 2;
	
	FireHandler(MyHandler nextHandler) {
		super(nextHandler);
	}
	
	void handleRequest(Request request) {
		if(request.getRequestCode() == requestCode) {
			System.out.println("Fire Handler...");
		}else {
			nextHandler.handleRequest(request);
		}	
	}
}

public class MyTestChainOfResponsibilityPattern {

	public static void main(String[] args) {
		
		MyHandler fireHandler = new FireHandler(null);
		MyHandler lowFuelHandler = new LowFuelHandler(fireHandler);
		
		Request lowFuelReq = new LowFuelRequest();
		Request fireDetectedReq = new FireDetectedRequest();
		
		lowFuelHandler.handleRequest(lowFuelReq);
		

	}

}
