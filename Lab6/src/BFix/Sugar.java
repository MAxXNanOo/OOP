package BFix;

public class Sugar extends Product{
	protected int weight;
	
	public Sugar(int price) {
		super("002", "Sugar", price);
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
}
