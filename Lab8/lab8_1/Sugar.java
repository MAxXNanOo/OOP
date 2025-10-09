package lab8_1;

public class Sugar extends Product{
	private double weight;
	public Sugar (double price) {
		super("Sugar ",price);
	}
	public void setWeight(double weight) {
		this.weight= weight;
	}
	public double getWeight() {
		return this.weight;
	}
	@Override
	public String getAmount() {
		return ""+this.weight+" Gram";
	}
	

}
