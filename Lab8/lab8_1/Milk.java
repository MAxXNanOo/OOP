package lab8_1;

public class Milk extends Product{
	private double volumn;
	public Milk(double price) {
		super("Milk",price);
		
	}
	public void setVolumn(double volumn) {
		this.volumn = volumn;
	}
	public double getVolumn() {
		return this.volumn;
	}
	
	@Override
	public String getAmount() {
		return ""+this.volumn+" CC";
	}
	
}
