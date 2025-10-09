package lab8_1;

public class FixedSalary extends Employee{
	private double monthly_saly;
	private SavingAccount.DebitCard card;
	public FixedSalary(String first,String last, String ssn,double monthly_saly) {
		super(first,last,ssn);
		this.monthly_saly=monthly_saly;
		
	}
	@Override
	public  double earnings() {
		
		return this.monthly_saly;
	}
	@Override
	public String toString() {
		return String.format("Fixed salary employee:%s\nmonthly salary %.2f"
				,super.toString(),this.monthly_saly);
	}
	public void setCard(SavingAccount.DebitCard card) {
		this.card = card;
	}
	public SavingAccount.DebitCard getCard() {
		return this.card;
	}
	

}
