package temp_package;
import java.util.*;

public class Bank {
	
	private ArrayList<Account> accounts = new ArrayList<Account>(); //needed to be initialized to get rid fo nullpointerexception
	private ArrayList<ATM> atms = new ArrayList<ATM>(); //needed to be initialized
	private String name;
	
	/**
	 *  Creates Bank object with name field
	 */
	public Bank(String name) {
		this.name = name;
	}
	
	
	/**
	 *  Gets name of Bank object
	 *  @return name of this Bank object
	 */ 
    public String getName() {
    		return this.name;
    }
	
    
    /**
	 *  Adds account to Bank object
	 *  @param the Account to add to Bank object
	 */ 
	public void addAccount(Account a) {
		this.accounts.add(a);
	}
	
	
	/**
	 *  Adds ATM to Bank object
	 *  @param the ATM to add to Bank object
	 */
	public void addATM(ATM a) {
		atms.add(a);
	}
	
	
	//AUTHORIZATION BEGIN
	
	
	/**
	 *  Checks whether the password is correct or not
	 *  @param the Account to check, the password
	 *  @return true if password is correct
	 */
	public boolean authPassword(Account a, String passwd) {
		if (!a.getPassword().equals(passwd)) {
			return false;
		}
		return true;
	}
	
	
	/**
	 *  Searches for Account object associated with the Bank
	 *  @param the name of the Account
	 *  @return the Account object if it is found
	 */
	public Account searchAccts(String name) {
		for (Account a: accounts) {
			if (a.getCardNum().equals(name)) {
				return a;
			}
		}
		return null;
	}
	
	
	/**
	 *  Searches for ATM object associated with the Bank
	 *  @param the name of the ATM
	 *  @return the ATM object if it is found
	 */
	public ATM searchATM(String name) {
		for (ATM a: atms) {
			if (a.getName().equals(name)) {
				return a;
			}
		}
		return null;
	}
	
	
	//TRANSACTION BEGINS
	
	
	/**
	 *  Checks that withdrawal is possible from a certain Account
	 *  @param the amount to be withdrawn, Account for the transaction
	 *  @return true if amount is within the Account's balance
	 */
	public boolean withdrawalCheck(int amt, Account a) {
		if (amt <= a.getBalance()) {
			return true;
		}
		return false;
	}
	
	
	/**
	 *  Deducts specified amount from Account's balance
	 *  @param the amount to withdraw, the Account for the transaction
	 *  Precondition: Account has some balance > 0, card is valid, Account information is valid
	 *  Postcondition: Account's balance is reduced by amount specified
	 */
	public void withdrawalAction(int amt, Account a) {
		a.reduceBalance(amt); //double check
	}
	
	
	/**
	 *  Displays all fields of a Bank's ATMs (name, bank, maximum amount you can withdraw at one time)
	 */
	public void getStateATM() {
		for (int i = 1; i <= atms.size(); i++) {
			System.out.print(atms.get(i-1).getName() + ": (");
			System.out.println("ATM" + i + " from " + this.getName() + ")");
			System.out.println("The maximum amount of cash a card can withdraw per day: $" + atms.get(i-1).getMax());
		}
	}
	
	
	/**
	 *  Displays all fields of a Bank (number of customers, account number, cash card expiration date, password, account balance)
	 */
	public void getStateBank() {
		System.out.println("Number of customers: " + accounts.size());
		String r = "nun";
		for(Account m: accounts) {
			r = ("Customer with Cash Card (bankid: " + m.getBank().getName() + ", account number: (" 
					+ m.getCardNum() + "), expires on: " + 
					getExpDateInString(m.getDate()) + ", password: " + m.getPassword() + ", balance: $" + m.getBalance() + ".");
			System.out.println(r);
		}
		
	}
	
	
	/**
     * Prints out the expiration date in a readable format
     * @return the exp date in mm/dd/yy format
     */
    public String getExpDateInString(GregorianCalendar expDate)
    {
        String year = Integer.toString(expDate.get(Calendar.YEAR));
        String month = Integer.toString(expDate.get(Calendar.MONTH) +1);
        String day = Integer.toString(expDate.get(Calendar.DAY_OF_MONTH));
        return month + "/" + day + "/" + year;
    }
	
}
