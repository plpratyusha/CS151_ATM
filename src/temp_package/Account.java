package temp_package;
import java.util.*;

public class Account {

	//features of Account: balance, acctNum
	//features of Card: cardNum, bankID, expiry, password
	private String cardNum;
	private Bank bankID;
	private GregorianCalendar expiry;
	private String password;
	private int balance;
	
	public Account(String cardNum, Bank bankID, GregorianCalendar expiry, String password, int balance) {
		this.cardNum 	= cardNum;
		this.bankID 		= bankID;
		this.expiry 		= expiry;
		this.password 	= password;
		this.balance 	= balance;
	}

	/**
	 *  Gets the card number of this Account
	 *  @return the card number of this Account
	 */
	public String getCardNum() {
		return this.cardNum;
	}
	
	
	/**
	 *  Gets the Bank this Account is linked to
	 *  @return the Bank this Account is linked to
	 */
	public Bank getBank() {
		return this.bankID;
	}
	
	
	/**
	 *  Gets the expiration date of the card this Account is linked to
	 *  @return the expiration date of the card this Account is linked to
	 */
	public GregorianCalendar getDate() {
		return this.expiry;
	}
	
	
	/**
	 *  Gets the password of this Account
	 *  @return the password of this Account
	 */
	public String getPassword() {
		return this.password;
	}
	
	
	/**
	 *  Gets the balance of this Account
	 *  @return the balance of this Account
	 */
	public int getBalance() {
		return this.balance;
	}
	
	
	/**
	 *  Reduces the balance of this Account
	 *  @param the amount to withdraw
	 *  Precondition: Account has some balance > 0
	 *  Postcondition: Account's balance is reduced by amount specified
	 */
	public void reduceBalance(int amt) {
		balance -= amt;
	}
	
}
