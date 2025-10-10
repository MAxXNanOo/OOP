package CWhatThe;

public class CommissionPay extends Employee{
	private double grossSales;
	private double commissionRate;
	
	public CommissionPay(String first, String last, String ssn, double grossSales, double commissionRate) {
		super(first, last, ssn);
		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}
	
	public double earnings() {
		return grossSales * commissionRate; 
	}
}
