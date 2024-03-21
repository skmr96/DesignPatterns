package factory;

interface Notification { // Product - Engine
	void notifyUser();
}

class SMSNotification implements Notification { // Concrete Product - F16AEngine
	public void notifyUser() {
		System.out.println("SMS Notification...");
	}	
}

class EmailNotification implements Notification { // Concrete Product - F16BEngine
	public void notifyUser() {
		System.out.println("Email Notification...");
	}	
}

abstract class NotificationService {  	// Creator - F16
	protected abstract Notification createNotification(); // Factory Method - Create Engine
	
	public void sendNotification() {
		Notification notification = createNotification();
		notification.notifyUser();
	}
}

class SMSNotificationService extends NotificationService { // Concrete Creator - creates the Product - new F16AEngine()
	public Notification createNotification() {
		return new SMSNotification();
	}
}

class EmailNotificationService extends NotificationService { 		// - new F16BEngine()
	protected Notification createNotification() {
		return new EmailNotification();
	}
}

public class TestFactoryPattern {
	public static void main(String[] args) {
		
		NotificationService sms = new SMSNotificationService();
		sms.sendNotification();
		
		NotificationService email = new EmailNotificationService();
		email.sendNotification();	
	}
}
