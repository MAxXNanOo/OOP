package lab8_1;
import java.util.*;
public class Cashier {
	private String name;
	double sum=0;
	Product OriginalIc[];
	SavingAccount.DebitCard card;
	
	public Cashier(String name) {
		this.name = name;
	}
	public void doPayment(InventoryCart ic,SavingAccount.DebitCard card) {
		this.card = card;
		this.OriginalIc=ic.getProducts().clone();
		boolean[] isCount = new boolean[ic.getSize()];
		Product []tmpProducts = ic.getProducts();
		
		for(int i=0;i<tmpProducts.length;i++) {
			if(tmpProducts[i]==null)continue;
			
			int count = 1;
			for(int j=i+1;j<tmpProducts.length;j++) {
				if(tmpProducts[j]!=null&&tmpProducts[i].getName().equals(tmpProducts[j].getName())&&tmpProducts[i].getAmount().equals(tmpProducts[j].getAmount())&&tmpProducts[i].getPrice()==tmpProducts[j].getPrice()) {
					count++;
					tmpProducts[j]=null;
				}
			}
			
//			System.out.printf("%d x %s %s %.2f\n",count, tmpProducts[i].getName(),tmpProducts[i].getAmount(),tmpProducts[i].getPrice());
			sum+=tmpProducts[i].getPrice()*count;
		}
		card.withdraw(sum-(sum*card.discount()/100));			
	}
	
	
	public void printReceipt() {
		System.out.printf("\t\tCARD TYPE:%s\n",card.type());
		System.out.printf("\t\tCARD NUMBER:xxx-xxx-%s\n\n",card.getCardNumber().substring(card.getCardNumber().length()-4));
		System.out.printf("\t\tPumpkin Shop   \n\n");
		boolean[] isCount = new boolean[OriginalIc.length];
		Product []tmpProducts = OriginalIc;
		
		for(int i=0;i<tmpProducts.length;i++) {
			if(tmpProducts[i]==null)continue;
			
			int count = 1;
			for(int j=i+1;j<tmpProducts.length;j++) {
				if(tmpProducts[j]!=null&&tmpProducts[i].getName().equals(tmpProducts[j].getName())&&tmpProducts[i].getAmount().equals(tmpProducts[j].getAmount())&&tmpProducts[i].getPrice()==tmpProducts[j].getPrice()) {
					count++;
					tmpProducts[j]=null;
				}
			}
			
			System.out.printf("\t\t%d x %s  %.2f\n",count, tmpProducts[i].getName(),tmpProducts[i].getPrice());
			
		}
		System.out.printf("\t\t-------------------     \n");
		System.out.printf("\t\tCARD DISCOUNT %.1f", card.discount());
		System.out.print("%\n\n");
		System.out.printf("\t\tTotal     %.2f",sum-sum*(card.discount()/100));
		System.out.printf("\n %.2f",card.getTotal());
	}
}

