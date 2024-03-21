package templatemethod;

abstract class CaffineDrink {
	
	final void prepareDrink() {
		boilWater();
		brew();
		pourInCup();
		if(customerNeedsCondiments()) {
			addingCondiments();
		}
	}
	
	abstract void brew();
	abstract void addingCondiments();
	
	void boilWater() {
		System.out.println("Boiling into water");
	}
	
	void pourInCup() {
		System.out.println("Pouring into cup");
	}
	
	protected boolean customerNeedsCondiments() {
		return true;
	}
}

class Coffee extends CaffineDrink {
	
	private boolean withSugar;
	
	Coffee(boolean withSugar) {
		this.withSugar = withSugar;
	}

	@Override
	void brew() {
		System.out.println("Dripping coffee through filter");
	}
	
	protected boolean customerNeedsCondiments() {
		return this.withSugar;
	}

	@Override
	void addingCondiments() {
		System.out.println("Adding sugar..");
	}
	
}

class Tea extends CaffineDrink {
	
	@Override
	void brew() {
		System.out.println("Steeping into tea");
	}

	@Override
	void addingCondiments() {
		System.out.println("Adding Lemon...");
	}
	
}

public class MyTestTemplateMethodPattern {

	public static void main(String[] args) {
		
		CaffineDrink cd = new Coffee(true);
		cd.prepareDrink();
		
		CaffineDrink cds = new Coffee(false);
		cds.prepareDrink();
		
		CaffineDrink tea = new Tea();
		tea.prepareDrink();
	}

}
