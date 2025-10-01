package BFix;

public class Milk extends Product{
	protected int volumn;
	
	public Milk(int price) {
		super("001", "Milk", price);
	}
	
	public void setVolumn(int volumn) {
		this.volumn = volumn;
	}

    @Override
    public void setWeight(int weight) {

    }
}
