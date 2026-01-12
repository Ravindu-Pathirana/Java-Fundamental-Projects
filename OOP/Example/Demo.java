class Vehicle{
	public void park(){
		System.out.println("Vehicle Parking");
	}
}
class Car extends Vehicle{
	public void park(){
		System.out.println("Car Parking");
	}
}
class Bus extends Vehicle{
	public void park(){
		System.out.println("Bus Parking");
	}
}
class Van extends Vehicle{
	public void park(){
		System.out.println("Van Parking");
	}
}

class Demo{
	public static void main(String args[]){
		Vehicle[] vr={new Car(),new Van(),new Car(),new Bus(),new Car()};
		for(Vehicle v1 : vr){
			v1.park(); //Single interface
		}
	}
}
