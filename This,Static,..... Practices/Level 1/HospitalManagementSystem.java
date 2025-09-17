public class HospitalManagementSystem {
    public static void main(String[] args) {
        Patient.hospitalName = "City Hospital";
        Patient p1 = new Patient("Isha", 28, "Fever", 7001);
        Object ref = p1;
        if (ref instanceof Patient) {
            ((Patient) ref).print();
        }
        System.out.println("Total Patients: " + Patient.getTotalPatients());
    }
}

class Patient {
    static String hospitalName;
    private static int totalPatients;
    final int patientID;
    String name;
    int age;
    String ailment;

    Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++;
    }

    static int getTotalPatients() {
        return totalPatients;
    }

    void print() {
        System.out.println("Hospital: " + hospitalName + ", Name: " + name + ", Age: " + age + ", Ailment: " + ailment + ", ID: " + patientID);
    }
}


