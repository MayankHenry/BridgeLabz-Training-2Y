import java.util.*;

class Employee {
	private String name;

	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

class Department {
	private String name;
	private List<Employee> employees = new ArrayList<>();

	public Department(String name) {
		this.name = name;
	}

	public void addEmployee(String employeeName) {
		employees.add(new Employee(employeeName));
	}

	public void listEmployees() {
		System.out.println("Department: " + name);
		for (Employee e : employees) {
			System.out.println(e.getName());
		}
	}
}

class Company {
	private String name;
	private List<Department> departments = new ArrayList<>();

	public Company(String name) {
		this.name = name;
	}

	public Department createDepartment(String deptName) {
		Department d = new Department(deptName);
		departments.add(d);
		return d;
	}

	public void showStructure() {
		System.out.println("Company: " + name);
		for (Department d : departments) {
			d.listEmployees();
		}
	}
}

public class CompanyDepartments_Composition {
	public static void main(String[] args) {
		Company c = new Company("TechCorp");
		Department d1 = c.createDepartment("Engineering");
		Department d2 = c.createDepartment("HR");
		d1.addEmployee("Asha");
		d1.addEmployee("Rahul");
		d2.addEmployee("Meera");
		c.showStructure();
	}
}
