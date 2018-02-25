package temp_package;

import java.util.*;

public class ATM {
	
	private int max_amt;
	private Bank bank;
	private String name;

	/**
	 *  Creates ATM object with fields: maximum amount, bank ID, name
	 */
	public ATM(int max_amt, Bank bank, String name) {
		this.max_amt = max_amt;
		this.bank = bank;
		this.name = name;
	}
	
	
	/**
	 *  Gets the Bank this ATM is linked with
	 *  @return the Bank this ATM is linked with
	 */
	public Bank getBank() {
		return this.bank;
	}
	
	
	/**
	 *  Gets name of this ATM
	 *  @return the name of this ATM
	 */
	public String getName() {
		return this.name;
	}
	
	
	/**
	 *  Gets the maximum daily withdrawal limit of this ATM
	 *  @return the maximum daily withdrawal limit of this ATM
	 */
	public int getMax() {
		return this.max_amt;
	}
	
	
	/**
	 *  Checks if the card is expired
	 *  @param the Account linked to the card that is being checked
	 *  @return false if card is expired
	 */
	public boolean checkExp(Account a) {
		Calendar today = new GregorianCalendar();
		if (a.getDate().before(today)) {
			return false;
		}
		return true;
	}
	
	
	/**
	 *  Checks if the card and the ATM are linked to the same Bank
	 *  @param the Account linked to the card that is being checked
	 *  @return false if card is linked to a different Bank
	 */
	public boolean checkBankId(Account a) {
		if (!a.getBank().equals(this.getBank())) {
			return false;
		}
		return true;
	}
	
	
	/**
	 *  Checks if the input amount is greater than the maximum daily withdrawal limit of this ATM
	 *  @param the amount to be withdrawn
	 *  @return false if amount is greater than maximum daily withdrawal limit of this ATM
	 */
	public boolean maxTransactionAmt(int amt) {
		if (amt > max_amt) {
			return false;
		}
		return true;
	}
	
	
	
	
}
