

public class Product{
    private int code;
    private String name;
    private double price;
    public Product(int code,String name,double price){
            this.code=code;
            this.name=name;
            this.price=price;
    }

    public int getcode(){
        return this.code;
    }
    public String getname(){
        return this.name;
    }
    public double getprice(){
        return this.price;
    }
}