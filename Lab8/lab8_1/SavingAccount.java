package lab8_1;

public class SavingAccount extends BaseAccount {
	private DebitCard card ;
	
	public class DebitCard extends Card {
		private String type;
		private double discount;
		private String cardNumber;
		private double total=0;
		public DebitCard(String cardNumber,double total,String type,double discount) {
			this.type=type;
			this.cardNumber=cardNumber;
			this.discount=discount;
			this.total=total;
			
		}
		@Override
		public boolean withdraw(double amount) {
			return SavingAccount.this.withdraw(amount);
		}

		@Override
		public String type() {
			// TODO Auto-generated method stub
			return this.type;
		}

		@Override
		public double discount() {
			// TODO Auto-generated method stub
			return this.discount;
		}
		
		public void setTotal(double newTotal) {
			this.total = newTotal;
		}
		public double getTotal() {
			return this.total;
		}
		public String getCardNumber() {
			return this.cardNumber;
		}

	}
	

	public SavingAccount(FixedSalary employee) {
		 this.card = new DebitCard(employee.getSSN(),0,"visa",2.5);
		 employee.setCard(this.card);
	}
	@Override
	public boolean withdraw(double amount) {
		if(card.getTotal()>=amount) {
			card.setTotal(card.getTotal()-amount);
		}
		return false;
	}

	@Override
	public boolean deposit(double amount) {
		if(amount>0) {
			card.setTotal(card.getTotal()+amount);
		}
		return false;
	}
	

}
