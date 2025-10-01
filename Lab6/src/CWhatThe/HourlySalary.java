package CWhatThe;

public class HourlySalary extends Employee{
	private double hourlyPay;
	private double hourseWorked;
	
	public HourlySalary(String first, String last, String ssn, double hourlyPay, double hourseWorked) {
		super(first, last, ssn);
		this.hourlyPay = hourlyPay;
		this.hourseWorked = hourseWorked;
	}
	
	public double earnings() {
		return hourlyPay * hourseWorked; 
	}
}
