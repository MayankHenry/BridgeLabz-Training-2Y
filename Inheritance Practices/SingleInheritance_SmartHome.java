public class SingleInheritance_SmartHome {
	public static void main(String[] args) {
		Thermostat t = new Thermostat("T100", "ON", 24);
		t.displayStatus();
	}
}

class Device {
	String deviceId;
	String status;

	Device(String deviceId, String status) {
		this.deviceId = deviceId;
		this.status = status;
	}
}

class Thermostat extends Device {
	int temperatureSetting;

	Thermostat(String deviceId, String status, int temperatureSetting) {
		super(deviceId, status);
		this.temperatureSetting = temperatureSetting;
	}

	void displayStatus() {
		System.out.println("Device: " + deviceId);
		System.out.println("Status: " + status);
		System.out.println("Temperature: " + temperatureSetting);
	}
}
