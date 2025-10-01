package BFix;

public class Coffee extends Product{
protected int weight;
	
	public Coffee(int price) {
		super("003", "Coffee", price);
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
