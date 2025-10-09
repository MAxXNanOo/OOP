package lab8_1;

public class Coffee extends Product{
	private double weight;
	public Coffee(double price) {
		super("Coffee",price);
		
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getWeight() {
		return this.weight;
	}
	@Override
	public String getAmount() {
		return ""+this.weight+" Gram";
	}
	
	
	

}
