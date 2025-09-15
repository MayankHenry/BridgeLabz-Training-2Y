import java.util.*;

abstract class Employee {
	private String employeeId;
	private String name;
	private double baseSalary;

	public Employee(String employeeId, String name, double baseSalary) {
		this.employeeId = employeeId;
		this.name = name;
		setBaseSalary(baseSalary);
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.trim().isEmpty()) return;
		this.name = name;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		if (baseSalary < 0) return;
		this.baseSalary = baseSalary;
	}

	public abstract double calculateSalary();

	public void displayDetails() {
		System.out.println("ID: " + employeeId);
		System.out.println("Name: " + name);
		System.out.println("Base Salary: " + baseSalary);
		System.out.println("Calculated Salary: " + calculateSalary());
	}
}

interface Department {
	void assignDepartment(String departmentName);
	String getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department {
	private String departmentName;
	private double fixedMonthlySalary;

	public FullTimeEmployee(String employeeId, String name, double baseSalary, double fixedMonthlySalary) {
		super(employeeId, name, baseSalary);
		setFixedMonthlySalary(fixedMonthlySalary);
	}

	public double getFixedMonthlySalary() {
		return fixedMonthlySalary;
	}

	public void setFixedMonthlySalary(double fixedMonthlySalary) {
		if (fixedMonthlySalary < 0) return;
		this.fixedMonthlySalary = fixedMonthlySalary;
	}

	@Override
	public double calculateSalary() {
		return getBaseSalary() + fixedMonthlySalary;
	}

	@Override
	public void assignDepartment(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String getDepartmentDetails() {
		return departmentName == null ? "No Department" : departmentName;
	}
}

class PartTimeEmployee extends Employee implements Department {
	private String departmentName;
	private int workedHours;
	private double hourlyRate;

	public PartTimeEmployee(String employeeId, String name, double baseSalary, int workedHours, double hourlyRate) {
		super(employeeId, name, baseSalary);
		setWorkedHours(workedHours);
		setHourlyRate(hourlyRate);
	}

	public int getWorkedHours() {
		return workedHours;
	}

	public void setWorkedHours(int workedHours) {
		if (workedHours < 0) return;
		this.workedHours = workedHours;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		if (hourlyRate < 0) return;
		this.hourlyRate = hourlyRate;
	}

	@Override
	public double calculateSalary() {
		return getBaseSalary() + workedHours * hourlyRate;
	}

	@Override
	public void assignDepartment(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String getDepartmentDetails() {
		return departmentName == null ? "No Department" : departmentName;
	}
}

public class EmployeeManagementEncap {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		FullTimeEmployee fte = new FullTimeEmployee("E001", "Aarav", 10000, 50000);
		fte.assignDepartment("Engineering");
		PartTimeEmployee pte = new PartTimeEmployee("E002", "Diya", 5000, 80, 300);
		pte.assignDepartment("Support");
		employees.add(fte);
		employees.add(pte);

		for (Employee e : employees) {
			e.displayDetails();
			if (e instanceof Department) {
				System.out.println("Department: " + ((Department) e).getDepartmentDetails());
			}
			System.out.println("---");
		}
	}
}
