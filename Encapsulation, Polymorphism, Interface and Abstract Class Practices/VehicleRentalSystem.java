import java.util.*;

interface Insurable {
	double calculateInsurance();
	String getInsuranceDetails();
}

abstract class RentalVehicle {
	private String vehicleNumber;
	private String type;
	private double rentalRate;

	public RentalVehicle(String vehicleNumber, String type, double rentalRate) {
		this.vehicleNumber = vehicleNumber;
		this.type = type;
		setRentalRate(rentalRate);
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public String getType() {
		return type;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		if (rentalRate < 0) return;
		this.rentalRate = rentalRate;
	}

	public abstract double calculateRentalCost(int days);
}

class CarRental extends RentalVehicle implements Insurable {
	public CarRental(String vehicleNumber, double rentalRate) {
		super(vehicleNumber, "Car", rentalRate);
	}

	@Override
	public double calculateRentalCost(int days) {
		return getRentalRate() * days;
	}

	@Override
	public double calculateInsurance() {
		return 500;
	}

	@Override
	public String getInsuranceDetails() {
		return "Standard Car Insurance";
	}
}

class BikeRental extends RentalVehicle implements Insurable {
	public BikeRental(String vehicleNumber, double rentalRate) {
		super(vehicleNumber, "Bike", rentalRate);
	}

	@Override
	public double calculateRentalCost(int days) {
		return getRentalRate() * days * 0.8;
	}

	@Override
	public double calculateInsurance() {
		return 200;
	}

	@Override
	public String getInsuranceDetails() {
		return "Basic Bike Insurance";
	}
}

class TruckRental extends RentalVehicle implements Insurable {
	public TruckRental(String vehicleNumber, double rentalRate) {
		super(vehicleNumber, "Truck", rentalRate);
	}

	@Override
	public double calculateRentalCost(int days) {
		return getRentalRate() * days * 1.5;
	}

	@Override
	public double calculateInsurance() {
		return 1000;
	}

	@Override
	public String getInsuranceDetails() {
		return "Heavy Vehicle Insurance";
	}
}

public class VehicleRentalSystem {
	public static void main(String[] args) {
		List<RentalVehicle> list = new ArrayList<>();
		list.add(new CarRental("MH01-1234", 2000));
		list.add(new BikeRental("MH02-5678", 500));
		list.add(new TruckRental("MH03-2468", 4000));

		for (RentalVehicle v : list) {
			System.out.println(v.getType() + " " + v.getVehicleNumber());
			System.out.println("Rental 3 days: " + v.calculateRentalCost(3));
			if (v instanceof Insurable) {
				Insurable ins = (Insurable) v;
				System.out.println("Insurance: " + ins.calculateInsurance());
				System.out.println(ins.getInsuranceDetails());
			}
			System.out.println("---");
		}
	}
}
