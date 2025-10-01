package Eabstract;

public class ContractEmployee extends Employee{
	protected int contractDuration;
	
	public ContractEmployee(String name, double salary, int con) {
		super(name, salary);
		contractDuration = con;
	}
	
	public double calculateBonus() {
		return salary * 0.05;
	}
	
	public void displayInfo() {
		System.out.printf("[%s]\nName : %s\nSalary : %.2f\nContract Duration : %d month\nBonus : %.2f"
						,getClass().getSimpleName(),name,salary,contractDuration,calculateBonus());
	}
}
