package lab8_1;

public class InventoryCart {
	private int SIZE;
	private Product [] products ;
	
	public InventoryCart(int n) {
		this.SIZE=n;
		products = new Product[n];
	}
	public void add(Product nwpdct) {
		for(int i=0;i<SIZE;i++) {
			if(products[i]==null) {
				products[i]=nwpdct;
				break;
			}
		}
	}
	
	public Product getProductAt(int i) {
		Product tmpPdct = products[i];
		products[i]=null;
		return tmpPdct;
	}
	public Product[] getProducts() {
		return products;
	}
	
	public int getSize() {
		return this.SIZE;
	}
}
