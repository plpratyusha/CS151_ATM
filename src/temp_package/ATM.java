package temp_package;

import java.util.GregorianCalendar;

public class ATM {
	
	private int max_amt;
	private Bank bank;
	private String name;

	public ATM(int max_amt, Bank bank, String name) {
		this.max_amt = max_amt;
		this.bank = bank;
		this.name = name;
	}
	
	public Bank getBank() {
		return this.bank;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getMax() {
		return this.max_amt;
	}
	
	//checks if expiry date and bank_id are valid
	public String checkCard(Account a, ATM atm) {
		
		GregorianCalendar today = new GregorianCalendar();
		
		if (a.getDate().compareTo(today) < 0) {				//DOUBLE CHECK
			return ("Error: this card is expired.");
		}
		
		if (!a.getBank().equals(atm.getBank())) {
			return ("Error: This card is not supported by this ATM.");
		}
		return ("Success.");
	}
	
	//TRANSACTION
	public boolean maxTransactionAmt(int amt) {
		if (amt > max_amt) {
			return false;
		}
		return true;
	}
	
	public void getState(Bank b) {
		
	}
	
}
