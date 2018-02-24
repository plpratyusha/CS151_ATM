package temp_package;
import java.util.*;

public class Bank {
	
	private ArrayList<Account> accounts = new ArrayList<Account>(); //needed to be initialized to get rid fo nullpointerexception
	private ArrayList<ATM> atms = new ArrayList<ATM>(); //needed to be initialized
	private String name;
	
	public Bank(String name) {
		this.name = name;
	}
	
	//Bank holds ArrayList of Accounts
	public void addAccount(Account a) {
		this.accounts.add(a);
	}
	
	public void addATM(ATM a) {
		atms.add(a);
	}
	
	//AUTHORIZATION
	//checks the password; ATM needs to read this output
	public String authPassword(Account a, String passwd) {
		if (!a.getPassword().equals(passwd)) {
			return ("Invalid password.");
		}
		return ("Success.");
	}
	
	public Account searchAccts(String name) {
		for (Account a: accounts) {
			if (a.getCardNum().equals(name)) {
				return a;
			}
		}
		return null;
	}
	
	
	//find ATM object associated with a Bank given an ATM name
	public ATM searchATM(String name) {
		for (ATM a: atms) {
			if (a.getName().equals(name)) {
				return a;
			}
		}
		return null;
	}
	
	//TRANSACTION
	public boolean withdrawalCheck(int amt, Account a) {
		if (amt <= a.getBalance()) {
			return true;
		}
		return false;
	}
	
	//MORE TRANSACTION
	public void withdrawalAction(int amt, Account a) {
		a.reduceBalance(amt); //double check
	}
	
	
	public void getStateATM() {
		for (int i = 1; i <= atms.size(); i++) {
			System.out.print(atms.get(i-1).getName() + ": (");
			System.out.println("ATM" + i + " from " + this.getName() + ")");
			System.out.println("The maximum amount of cash a card can withdraw per day: $" + atms.get(i-1).getMax());
		}
	}
	
	
	//print state of Bank object
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
     * Prints out the expiration date in readable format
     * @return the exp date in mm/dd/yy format
     */
    public String getExpDateInString(GregorianCalendar expDate)
    {
        String year = Integer.toString(expDate.get(Calendar.YEAR));
        String month = Integer.toString(expDate.get(Calendar.MONTH) +1);
        String day = Integer.toString(expDate.get(Calendar.DAY_OF_MONTH));
        return month + "/" + day + "/" + year;
    }
    
    public String getName() {
    		return this.name;
    }
	
}
