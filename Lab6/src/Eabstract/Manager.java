package Eabstract;

public class Manager extends Employee{
	protected String department;
	
	public Manager(String name, double salary, String department) {
		super(name,salary);
		this.department = department;
	}
	
	public double calculateBonus() {
		return salary * 0.2;
	}
	
	public void displayInfo() {
		System.out.printf("[%s]\nName : %s\nSalary : %.2f\nDepartment : %s\nBonus : %.2f",getClass().getSimpleName(),name,salary,department,calculateBonus());
	}
}
