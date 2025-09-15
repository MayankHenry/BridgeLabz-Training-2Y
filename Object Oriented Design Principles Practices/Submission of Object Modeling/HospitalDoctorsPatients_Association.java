import java.util.*;

class Doctor {
	private String name;
	private Set<Patient> patients = new HashSet<>();

	public Doctor(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void consult(Patient patient) {
		patients.add(patient);
		patient.addDoctor(this);
		System.out.println("Consultation: Dr. " + name + " with " + patient.getName());
	}
}

class Patient {
	private String name;
	private Set<Doctor> doctors = new HashSet<>();

	public Patient(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addDoctor(Doctor doctor) {
		doctors.add(doctor);
	}
}

class Hospital {
	private String name;
	private List<Doctor> doctors = new ArrayList<>();
	private List<Patient> patients = new ArrayList<>();

	public Hospital(String name) {
		this.name = name;
	}

	public Doctor addDoctor(String name) {
		Doctor d = new Doctor(name);
		doctors.add(d);
		return d;
	}

	public Patient addPatient(String name) {
		Patient p = new Patient(name);
		patients.add(p);
		return p;
	}
}

public class HospitalDoctorsPatients_Association {
	public static void main(String[] args) {
		Hospital h = new Hospital("City Hospital");
		Doctor d1 = h.addDoctor("Sharma");
		Doctor d2 = h.addDoctor("Khan");
		Patient p1 = h.addPatient("Amit");
		Patient p2 = h.addPatient("Neha");
		d1.consult(p1);
		d1.consult(p2);
		d2.consult(p2);
	}
}
