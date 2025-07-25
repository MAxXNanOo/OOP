class Bank{
    public static void main(String[] args) {
        BankAccount p1 = new BankAccount("P1");
        BankAccount p2 = new BankAccount("P2", 500, new Date(1,11,2015));
        p1.deposit(500);
        p2.transfer(p1, 300);
        p2.withdraw(300);
        //System.out.printf("%f",p2.getAmount());

        System.out.printf("%s Amount : %.2f\n",p1.getInfo(),p1.property());
        System.out.printf("%s Amount : %.2f",p2.getInfo(),p2.property());
    }
}