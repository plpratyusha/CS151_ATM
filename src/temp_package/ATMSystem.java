package temp_package;
import java.util.*;

public class ATMSystem {

	public static void main(String[] args) {
		HashMap<String, ATM> atm_map = new HashMap<String, ATM>();
		
		Bank BankOfA = new Bank("BankOfA");
		Bank BankOfB = new Bank("BankOfB");
		
		//Create ATMs
		ATM ATM1_A = new ATM(50, BankOfA, "ATM1_A");
		ATM ATM2_A = new ATM(50, BankOfA, "ATM2_A");
		ATM ATM1_B = new ATM(50, BankOfB, "ATM1_B");
		ATM ATM2_B = new ATM(50, BankOfB, "ATM2_B");
		
		atm_map.put(ATM1_A.getName(), ATM1_A);
		atm_map.put(ATM2_A.getName(), ATM2_A);
		atm_map.put(ATM1_B.getName(), ATM1_B);
		atm_map.put(ATM2_B.getName(), ATM2_B);
		

		//Create Accounts and add Accounts + ATMs for BankOfA
		Account acct1A = new Account("A11", BankOfA, new GregorianCalendar(2008, 12, 1), "mypasswd", 40);
		Account acct2A = new Account("A12", BankOfA, new GregorianCalendar(2020, 1, 1), "password", 40);
		BankOfA.addAccount(acct1A);
		BankOfA.addAccount(acct2A);
		BankOfA.addATM(ATM1_A);
		BankOfA.addATM(ATM2_A);
		
		//Create Accounts and Accounts + ATMs for BankOfB
		Account acct1B = new Account("B111", BankOfB, new GregorianCalendar(2020, 12, 1), "passs", 40);
		Account acct2B = new Account("B122", BankOfB, new GregorianCalendar(2020, 12, 1), "worddd", 40);
		Account acct3B = new Account("B133", BankOfB, new GregorianCalendar(2020, 12, 1), "passsworddd", 40);
		BankOfB.addAccount(acct1B);
		BankOfB.addAccount(acct2B);
		BankOfB.addAccount(acct3B);
		BankOfB.addATM(ATM1_B);
		BankOfB.addATM(ATM2_B);
		
		//Print states of Banks
		System.out.println("States of two Banks are below.");
		System.out.println();
		System.out.println("Assume all accounts have $40 preloaded.");
		System.out.println(BankOfA.getName());
		BankOfA.getStateBank();
		System.out.println();
		System.out.println(BankOfB.getName());
		BankOfB.getStateBank();
		System.out.println();
		
		//Print states of ATMs
		System.out.println("States of four ATMs (2 for each Bank) are below:");
		BankOfA.getStateATM();
		BankOfB.getStateATM();
		System.out.println();
		
		
		//Interactive part begin
		
		
		//VALIDITY
		
		//ATM ask & save
		System.out.println("Enter your choice of ATM.");
		Scanner sc_atm = new Scanner(System.in);
		String atm = sc_atm.next(); //atm holds name of ATM
		ATM atm_pointer = null; //atm_pointer holds ATM object
		
		//find the ATM
		for (String key: atm_map.keySet()) {
			if (atm.equals(key)) {
				atm_pointer = atm_map.get(key);
			}
		}
		
		if (atm_pointer == null) {
			System.out.println("Please enter a valid ATM.");
			Scanner sc_atm2 = new Scanner(System.in);
			atm = sc_atm2.next(); //atm2 holds name of ATM
			
			for (String key: atm_map.keySet()) {
				if (atm.equals(key)) {
					atm_pointer = atm_map.get(key);
				}
			}
		}
		
		
		//Card ask & save
		System.out.println("Enter your card id.");
		Scanner sc_acct = new Scanner(System.in);
		String acct = sc_acct.next();
		Account acct_pointer = null;

		acct_pointer = atm_pointer.getBank().searchAccts(acct); //gets Bank associated with this Account, finds it in Bank
		
		//if card number is incorrectly entered
		if (acct_pointer == null) {
			System.out.println("Please enter a valid card.");
			sc_acct = new Scanner(System.in);
			acct = sc_acct.next();
		}
		
		//if bank_id of card is wrong
		if (atm_pointer.checkBankId(acct_pointer) == false) {
			System.out.println("This card is not supported by this ATM. Please enter a valid card.");
			
			sc_acct = new Scanner(System.in);
			acct = sc_acct.next();
		}
		
		//if card is expired
		if (atm_pointer.checkExp(acct_pointer) == false) {
			System.out.println("This card is expired and returned to you. Please enter a valid card.");
			
			sc_acct = new Scanner(System.in);
			acct = sc_acct.next();
		}
		
		acct_pointer = atm_pointer.getBank().searchAccts(acct); //assume same mistake is not made twice
		
		
		//AUTHORIZATION
		
		
		//mayhap this should be in ATM and have this bit cleaner here
		System.out.println("The card is accepted. AUTHORIZATION begin. Please enter your password.");
		Scanner check_pswd = new Scanner(System.in);
		String pswd = check_pswd.next();
		
		if (!atm_pointer.getBank().authPassword(acct_pointer, pswd)) {
			System.out.println("This is a wrong password. Enter your password.");
			check_pswd = new Scanner(System.in);
			pswd = check_pswd.next(); //assuming doesn't make same mistake twice
		}
		//at this point pswd should be the password.


		//TRANSACTION

		
		//initiate transaction dialogue
		System.out.println("Authorization is accepted. Start your transaction by entering the amount to withdraw.");
		Scanner the_amt = new Scanner(System.in);
		int amt = the_amt.nextInt();

		while (acct_pointer.getBalance() >= 0) {

			if (!atm_pointer.maxTransactionAmt(amt)) { //if amount entered is over maximum amount per transaction
				System.out.println("This amount exceeds the maximum amount you can withdraw per transaction. Please enter the amount or -1 to quit."); 

				Scanner the_amt2 = new Scanner(System.in);
				amt = the_amt2.nextInt(); //assume same mistake isn't repeated
				
				if (amt == -1) {
					break;
				}
			}
			//at this point the amount is accepted and Bank gets to check if the account can handle it.

			if (!acct_pointer.getBank().withdrawalCheck(amt, acct_pointer)) { //if account has < amount the customer requested to withdraw
				System.out.println("The amount exceeds the current balance. Enter another amount or -1 to quit.");

				Scanner the_amt3 = new Scanner(System.in);
				amt = the_amt3.nextInt(); //assume same mistake isn't repeated
				
				if (amt == -1) {
					break;
				}
			}
			//now amt is good & can be reduced

			acct_pointer.getBank().withdrawalAction(amt, acct_pointer);
			System.out.println("$" + amt + " dollars is withdrawn from your account. Your current balance is $" + acct_pointer.getBalance() + ". "
					+ "If you have more transactions, enter the amount or -1 to quit.");

			Scanner the_amt5 = new Scanner(System.in);
			amt = the_amt5.nextInt();
			
			if (amt == -1) {
				break;
			}

		}
		
	}
}
