public class EmployeeManagementSystem {
	public static void main(String[] args) {
		Employee e1 = new Manager("Asha", 101, 90000, 8);
		Employee e2 = new Developer("Ravi", 102, 80000, "Java");
		Employee e3 = new Intern("Neha", 103, 20000, 6);

		Employee[] employees = {e1, e2, e3};
		for (Employee e : employees) {
			e.displayDetails();
			System.out.println("---");
		}
	}
}

class Employee {
	String name;
	int id;
	double salary;

	Employee(String name, int id, double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	void displayDetails() {
		System.out.println("Name: " + name);
		System.out.println("Id: " + id);
		System.out.println("Salary: " + salary);
	}
}

class Manager extends Employee {
	int teamSize;

	Manager(String name, int id, double salary, int teamSize) {
		super(name, id, salary);
		this.teamSize = teamSize;
	}

	@Override
	void displayDetails() {
		super.displayDetails();
		System.out.println("Team Size: " + teamSize);
	}
}

class Developer extends Employee {
	String programmingLanguage;

	Developer(String name, int id, double salary, String programmingLanguage) {
		super(name, id, salary);
		this.programmingLanguage = programmingLanguage;
	}

	@Override
	void displayDetails() {
		super.displayDetails();
		System.out.println("Language: " + programmingLanguage);
	}
}

class Intern extends Employee {
	int durationMonths;

	Intern(String name, int id, double salary, int durationMonths) {
		super(name, id, salary);
		this.durationMonths = durationMonths;
	}

	@Override
	void displayDetails() {
		super.displayDetails();
		System.out.println("Duration (months): " + durationMonths);
	}
}
