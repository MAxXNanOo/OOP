package Demployee;

public class Manager extends Employee{
	private String department;
	
	public Manager(String name, double salary, String department) {
		super(name, salary);
		this.department = department;
	}
	
	public String toString() {
		return String.format("Name : %s\nSalary : %.2f\nDepartmetn : %s",name,salary,department);
	}
}
