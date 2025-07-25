class BankAccount{

    private String name;
    private double amount;
    private Date date;

    public BankAccount(String n){
        name = n;
        this.amount = 0;
        this.date = new Date(25,7,2025);
    }

    public BankAccount(String name, double amount, Date date){
        this.name = name;
        this.amount = amount;
        this.date = date;
    }

    void deposit(double amount){
        this.amount+=amount;
    }

    boolean withdraw(double amount ){
        if(amount>property()){
            System.out.println("Your amout not enough");
            return false;
        }
        else{
            this.amount-=amount;
            return true;
        }
    }

    void transfer(BankAccount other, double amount){
        if(withdraw(amount)){
            other.amount+=amount;
        }
    }

    public double property(){
        return this.amount;
    }

    public String getAllDate(){
        return date.getDay() + "/" + date.getMonth() + "/" + date.getYear() ;
    }

    public String getInfo(){
        return "Name : " + name + " Date : " + getAllDate();
    }


}