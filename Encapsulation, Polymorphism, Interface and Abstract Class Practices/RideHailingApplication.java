import java.util.*;

interface GPS {
	String getCurrentLocation();
	void updateLocation(String location);
}

abstract class RideVehicle {
	private String vehicleId;
	private String driverName;
	private double ratePerKm;
	private String location;

	public RideVehicle(String vehicleId, String driverName, double ratePerKm) {
		this.vehicleId = vehicleId;
		this.driverName = driverName;
		this.ratePerKm = Math.max(ratePerKm, 0);
		this.location = "Unknown";
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public String getDriverName() {
		return driverName;
	}

	public double getRatePerKm() {
		return ratePerKm;
	}

	protected void setLocation(String location) {
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public String getVehicleDetails() {
		return vehicleId + " - " + driverName + " @ " + ratePerKm + "/km";
	}

	public abstract double calculateFare(double distance);
}

class CarRide extends RideVehicle implements GPS {
	public CarRide(String vehicleId, String driverName, double ratePerKm) {
		super(vehicleId, driverName, ratePerKm);
	}

	@Override
	public double calculateFare(double distance) {
		return getRatePerKm() * distance;
	}

	@Override
	public String getCurrentLocation() {
		return getLocation();
	}

	@Override
	public void updateLocation(String location) {
		setLocation(location);
	}
}

class BikeRide extends RideVehicle implements GPS {
	public BikeRide(String vehicleId, String driverName, double ratePerKm) {
		super(vehicleId, driverName, ratePerKm);
	}

	@Override
	public double calculateFare(double distance) {
		return getRatePerKm() * distance * 0.8;
	}

	@Override
	public String getCurrentLocation() {
		return getLocation();
	}

	@Override
	public void updateLocation(String location) {
		setLocation(location);
	}
}

class AutoRide extends RideVehicle implements GPS {
	public AutoRide(String vehicleId, String driverName, double ratePerKm) {
		super(vehicleId, driverName, ratePerKm);
	}

	@Override
	public double calculateFare(double distance) {
		return Math.max(30, getRatePerKm() * distance);
	}

	@Override
	public String getCurrentLocation() {
		return getLocation();
	}

	@Override
	public void updateLocation(String location) {
		setLocation(location);
	}
}

public class RideHailingApplication {
	public static void main(String[] args) {
		List<RideVehicle> rides = new ArrayList<>();
		CarRide car = new CarRide("CAR101", "Arjun", 15);
		BikeRide bike = new BikeRide("BIK202", "Neeraj", 10);
		AutoRide auto = new AutoRide("AUT303", "Ramesh", 12);
		car.updateLocation("MG Road");
		bike.updateLocation("Station");
		auto.updateLocation("Market");
		rides.add(car);
		rides.add(bike);
		rides.add(auto);

		for (RideVehicle v : rides) {
			System.out.println(v.getVehicleDetails());
			System.out.println("Location: " + ((GPS) v).getCurrentLocation());
			System.out.println("Fare 12.5 km: " + v.calculateFare(12.5));
			System.out.println("---");
		}
	}
}
