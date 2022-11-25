
//Implementing abstraction
abstract class Vehicle {
	
	//for Encapsulation
	private String speed;
	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	
	public void run() {
		System.out.println("Running");
	}
	
	//abstract method
	abstract void start();
}

//Inheritance
class Car extends Vehicle {
	
	//polymorphism- method overriding example
	public void run() {
		System.out.println("Car Running");
	}

	@Override
	void start() {
		System.out.println("Car started");
	}
}

public class OOPConcepts {

	public static void main(String[] args) {

		Car car=new Car();
		
		//for encapsulation
		car.setSpeed("100");
		System.out.println(car.getSpeed());
		
		//polymorphism- function call
		car.run();
		
		//abstract function call
		car.start();
		
	}

}
