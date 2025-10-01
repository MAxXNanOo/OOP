package CWhatThe;

public class FixedSalary extends Employee{
	private double salary;
	
	public FixedSalary(String first, String last, String ssn, double salary) {
		super(first, last, ssn);
		this.salary = salary;
	}
	
	public double earnings() {
		return salary; 
	}
	
	
}
