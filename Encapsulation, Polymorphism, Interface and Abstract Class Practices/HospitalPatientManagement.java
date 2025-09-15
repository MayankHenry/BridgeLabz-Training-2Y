import java.util.*;

interface MedicalRecord {
	void addRecord(String record);
	List<String> viewRecords();
}

abstract class Patient {
	private String patientId;
	private String name;
	private int age;
	private String diagnosis;
	private List<String> records = new ArrayList<>();

	public Patient(String patientId, String name, int age) {
		this.patientId = patientId;
		this.name = name;
		this.age = Math.max(age, 0);
	}

	public String getPatientId() {
		return patientId;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	protected List<String> getInternalRecords() {
		return records;
	}

	public String getPatientDetails() {
		return patientId + " - " + name + ", Age " + age;
	}

	public abstract double calculateBill();
}

class InPatient extends Patient implements MedicalRecord {
	private int daysAdmitted;
	private double roomRate;

	public InPatient(String patientId, String name, int age, int daysAdmitted, double roomRate) {
		super(patientId, name, age);
		this.daysAdmitted = Math.max(daysAdmitted, 0);
		this.roomRate = Math.max(roomRate, 0);
	}

	@Override
	public double calculateBill() {
		return daysAdmitted * roomRate + 2000;
	}

	@Override
	public void addRecord(String record) {
		getInternalRecords().add(record);
	}

	@Override
	public List<String> viewRecords() {
		return new ArrayList<>(getInternalRecords());
	}
}

class OutPatient extends Patient implements MedicalRecord {
	private int consultations;
	private double feePerConsultation;

	public OutPatient(String patientId, String name, int age, int consultations, double feePerConsultation) {
		super(patientId, name, age);
		this.consultations = Math.max(consultations, 0);
		this.feePerConsultation = Math.max(feePerConsultation, 0);
	}

	@Override
	public double calculateBill() {
		return consultations * feePerConsultation;
	}

	@Override
	public void addRecord(String record) {
		getInternalRecords().add(record);
	}

	@Override
	public List<String> viewRecords() {
		return new ArrayList<>(getInternalRecords());
	}
}

public class HospitalPatientManagement {
	public static void main(String[] args) {
		List<Patient> patients = new ArrayList<>();
		InPatient ip = new InPatient("P001", "Meera", 30, 3, 3000);
		ip.setDiagnosis("Appendicitis");
		ip.addRecord("Surgery completed");
		OutPatient op = new OutPatient("P002", "Sanjay", 25, 2, 500);
		op.setDiagnosis("Flu");
		op.addRecord("Medicines prescribed");
		patients.add(ip);
		patients.add(op);

		for (Patient p : patients) {
			System.out.println(p.getPatientDetails());
			System.out.println("Diagnosis: " + p.getDiagnosis());
			System.out.println("Bill: " + p.calculateBill());
			if (p instanceof MedicalRecord) {
				System.out.println("Records: " + ((MedicalRecord) p).viewRecords());
			}
			System.out.println("---");
		}
	}
}
