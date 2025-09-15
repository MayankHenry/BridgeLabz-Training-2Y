public class VehicleTransportSystem {
	public static void main(String[] args) {
		Vehicle v1 = new Car(180, "Petrol", 5);
		Vehicle v2 = new Truck(120, "Diesel", 10000);
		Vehicle v3 = new Motorcycle(200, "Petrol", true);

		Vehicle[] vehicles = {v1, v2, v3};
		for (Vehicle v : vehicles) {
			v.displayInfo();
			System.out.println("---");
		}
	}
}

class Vehicle {
	int maxSpeed;
	String fuelType;

	Vehicle(int maxSpeed, String fuelType) {
		this.maxSpeed = maxSpeed;
		this.fuelType = fuelType;
	}

	void displayInfo() {
		System.out.println("Max Speed: " + maxSpeed);
		System.out.println("Fuel Type: " + fuelType);
	}
}

class Car extends Vehicle {
	int seatCapacity;

	Car(int maxSpeed, String fuelType, int seatCapacity) {
		super(maxSpeed, fuelType);
		this.seatCapacity = seatCapacity;
	}

	@Override
	void displayInfo() {
		super.displayInfo();
		System.out.println("Seat Capacity: " + seatCapacity);
	}
}

class Truck extends Vehicle {
	int loadCapacityKg;

	Truck(int maxSpeed, String fuelType, int loadCapacityKg) {
		super(maxSpeed, fuelType);
		this.loadCapacityKg = loadCapacityKg;
	}

	@Override
	void displayInfo() {
		super.displayInfo();
		System.out.println("Load Capacity (kg): " + loadCapacityKg);
	}
}

class Motorcycle extends Vehicle {
	boolean hasABS;

	Motorcycle(int maxSpeed, String fuelType, boolean hasABS) {
		super(maxSpeed, fuelType);
		this.hasABS = hasABS;
	}

	@Override
	void displayInfo() {
		super.displayInfo();
		System.out.println("ABS: " + (hasABS ? "Yes" : "No"));
	}
}
