package BFix;

public class Cashier {
    private String cashierName;
    private int i,j,pieces=1;
    private int Total=0;
    
    public Cashier(String cashierName){
        this.cashierName = cashierName;
    }

    public void printReceipt(InventoryCart Cart){
        System.out.printf("\tPumpkin Shop (%s)\n", cashierName);
        int total = 0;

        Product[] products = Cart.getAllProduct();

        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) continue;

            int count = 1;
            for (int j = i + 1; j < products.length; j++) {
                if (products[j] != null && products[i].gId().equals(products[j].gId())) {
                    count++;
                    products[j] = null;
                }
            }
            System.out.printf("%d x %s (%s)\t%d\n", count, products[i].gName(), products[i].gId(), products[i].gPrice());
            total += products[i].gPrice() * count;
        }

        System.out.println("\t----------");
        System.out.printf("\tTotal\t\t%d$\n", total);
    }

}
