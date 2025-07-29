
public class Product {
    private String id;
    private String name;
    private int price;

    public Product(String id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

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
