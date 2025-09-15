import java.util.*;

class Faculty {
	private String name;

	public Faculty(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

class DepartmentUnit {
	private String name;
	private List<Faculty> assignedFaculty = new ArrayList<>();

	public DepartmentUnit(String name) {
		this.name = name;
	}

	public void assignFaculty(Faculty f) {
		assignedFaculty.add(f);
	}

	public String getName() {
		return name;
	}

	public void listAssignedFaculty() {
		System.out.println("Department: " + name);
		for (Faculty f : assignedFaculty) {
			System.out.println(f.getName());
		}
	}
}

class University {
	private String name;
	private List<DepartmentUnit> departments = new ArrayList<>();

	public University(String name) {
		this.name = name;
	}

	public DepartmentUnit createDepartment(String deptName) {
		DepartmentUnit d = new DepartmentUnit(deptName);
		departments.add(d);
		return d;
	}

	public void show() {
		System.out.println("University: " + name);
		for (DepartmentUnit d : departments) {
			d.listAssignedFaculty();
		}
	}
}

public class University_Faculty_Departments_CompAgg {
	public static void main(String[] args) {
		University uni = new University("National University");
		DepartmentUnit cs = uni.createDepartment("Computer Science");
		DepartmentUnit eco = uni.createDepartment("Economics");
		Faculty f1 = new Faculty("Dr. Rao");
		Faculty f2 = new Faculty("Dr. Sen");
		cs.assignFaculty(f1);
		eco.assignFaculty(f2);
		uni.show();
	}
}
