public class Cashier {
    private String cashierName;
    private int i,j,pieces=1;
    private int Total=0;
    
    public Cashier(String cashierName){
        this.cashierName = cashierName;
    }

    public void printReceipt(InventoryCart Cart){
        System.out.printf("\tPumpkin Shop (%s)\n",cashierName);

        for(i=0 ; i < Cart.getAllProduct().length ; i++){
            if(Cart.getAllProduct()[i] == null)
                continue;
            pieces = 1;
            for(j=i+1 ; j < Cart.getAllProduct().length ; j++){
                if(Cart.getAllProduct()[i] == Cart.getAllProduct()[j]){
                    pieces++;
                    Cart.getAllProduct()[j] = null ;
                }
            }
            Total += Cart.getAllProduct()[i].gPrice() * pieces;
            System.out.printf("%d x %s (%s)\t%d\n",  pieces,  Cart.getAllProduct()[i].gName(),  Cart.getAllProduct()[i].gId(),  Cart.getAllProduct()[i].gPrice());
        }

        System.out.printf("\t----------\n");
        System.out.printf("\tTotal\t\t%d$",Total);
    }
}
