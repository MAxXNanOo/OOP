package BFix;

public abstract class Product {
	private String id;
    private String name;
    private int price;
    
//    private int weight;

    public Product(String id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    
    public abstract void setWeight(int weight);
    
    

    public String gId(){
        return id;
    }

    public String gName(){
        return name;
    }

    public int gPrice(){
        return price;
    }
}
