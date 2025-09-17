public class EmployeeSystem {
    public static void main(String[] args) {
        Employee.companyName = "Tech Corp";
        Employee e1 = new Employee("Sara", 501, "Engineer");
        Employee e2 = new Employee("Liam", 502, "Manager");
        Object ref = e2;
        if (ref instanceof Employee) {
            ((Employee) ref).printDetails();
        }
        Employee.displayTotalEmployees();
    }
}

class Employee {
    static String companyName;
    private static int totalEmployees;
    final int id;
    String name;
    String designation;

    Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    void printDetails() {
        System.out.println("Company: " + companyName + ", Name: " + name + ", ID: " + id + ", Role: " + designation);
    }
}


