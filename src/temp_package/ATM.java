package temp_package;

import java.util.*;

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
	
	//checks if expiry date is valid
	public boolean checkExp(Account a) {
		Calendar today = new GregorianCalendar();
		if (a.getDate().before(today)) {
			return false;
		}
		return true;
	}
	
	//checks if bank_id is valid
	public boolean checkBankId(Account a) {
		if (!a.getBank().equals(this.getBank())) {
			return false;
		}
		return true;
	}
	
	//TRANSACTION
	public boolean maxTransactionAmt(int amt) {
		if (amt > max_amt) {
			return false;
		}
		return true;
	}
	
	
	
	
}
