package Demployee;

public class Employee {
	protected String name;
	protected double salary;
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public String toString() {
		return String.format("Name : %s\nSalary : %.2f",name,salary);
	}
}
