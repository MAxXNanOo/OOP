package Eabstract;

public abstract class Employee extends Person {
	protected double salary;
	
	public Employee(String name, double salary) {
		super(name);
		this.salary = salary;
	}
	public abstract double calculateBonus();
	
	public void displayInfo() {
		System.out.printf("Name : %s\nSalary : %.2f",name,salary);
	}
}
