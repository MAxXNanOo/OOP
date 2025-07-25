class product{
    private int code;
    private String name;
    private double price;

    public product(int c, String n, double p){
        code = c;
        name = n;
        price = p;
    }

    public int  gCode(){
        return code;
    }

    public String gName(){
        return name;
    }

    public double gPrice(){
        return price;
    }

}