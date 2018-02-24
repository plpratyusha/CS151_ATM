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

	public String getCardNum() {
		return this.cardNum;
	}
	
	public Bank getBank() {
		return this.bankID;
	}
	
	public GregorianCalendar getDate() {
		return this.expiry;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public void reduceBalance(int amt) {
		balance -= amt;
	}
	
}
