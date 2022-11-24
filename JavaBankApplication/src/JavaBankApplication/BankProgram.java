package JavaBankApplication;

// ************************************************************************
// BankProgram.java	 Template created on 15.9.2016
// - The program class for the BankApplication exercise
// ************************************************************************
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class BankProgram {
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Account> accountList = new ArrayList<Account>();

	// *** DO NOT change anything in the main method ***
	public static void main(String[] args) {
		int choice = -1;

		while (choice != 0) {

			switch (choice) {
			case 1:
				listAccounts();
				break;
			case 2:
				addAccount();
				break;
			case 3:
				depositMoney();
				break;
			case 4:
				withdrawMoney();
				break;
			case 5:
				deleteAccount();
				break;
			}

			displayMenu();
			choice = Integer.parseInt(input.nextLine());
		}

		System.out.println("\nThe program ends now. Bye!");
		input.close();
	}

	private static void displayMenu() {
		String line = "-----------------------------------------------------"
				+ "---------------------------------------------------------------";
		System.out.println(line);
		System.out.print(" 0 = Quit | 1 = List accounts | 2 = Add an account | "
				+ "3 = Deposit money | 4 = Withdraw money | 5 = Delete an account \n");
		System.out.println(line);
		System.out.print("Enter your choice: ");
	}

	// *** NB! Edit only the methods below. DO NOT add any other methods! ***

	private static void listAccounts() {
		DecimalFormat twoDecimals = new DecimalFormat("0.00");
		System.out.print("\n*** Account list ***\n");
		for (Account accounts : accountList) {
			System.out.println("Number: " + accounts.getAccountNumber() + " | Balance: "
					+ twoDecimals.format(accounts.getBalance()));
		}
		

	}


	private static void addAccount() {
		System.out.print("\n*** Add an account ***\n");
		System.out.print("Enter account number: ");
		Scanner input = new Scanner(System.in);
		
		for (int i = 0; i <= accountList.size(); i++) {
			System.out.print("Enter account number: ");
			String inputString = input.nextLine();
			if (findAccount(inputString) == null && !inputString.isEmpty()) {
				accountList.add(new Account(inputString, 0));
				System.out.println("Account created successfully!");
				break;
			} else {
				System.out.println("Account not created. Account: " + inputString + " exists already!");
			}
		}

	}

	// Finds an account in accountList by given account number.
	// Returns either a reference to the account object
	// OR null if the account is not found in accountList.
	private static Account findAccount(String accountNumber) {
		Account myAccount = null;
		for (int i = 0; i < accountList.size(); i++) {
			if (accountNumber.equals(accountList.get(i).getAccountNumber())) {
				myAccount = accountList.get(i);
			}
		}

		return myAccount;
	}

	private static void depositMoney() {
		System.out.print("\n*** Deposit money to an account ***\n");
		System.out.println("Enter account number: ");
		String inputAccount = input.nextLine();
		Account myAccount = findAccount(inputAccount);
		if (myAccount != null) {
			System.out.print("Enter the amount to be deposited: ");
			double inputAmount = Double.parseDouble(input.nextLine());
			if (inputAmount < 0) {
				System.out.println("Cannot deposit a negative amount!");
			} else {
				myAccount.deposit(inputAmount);
				System.out.println("Deposit completed successfully!");
			}

		} else {
			System.out.println("Account " + inputAccount + " doesn't exists!");
		}

	}

	private static void withdrawMoney() {
		System.out.print("\n*** Withdraw money from an account ***\n");
		System.out.print("Enter account number: ");
		String inputAccount = input.nextLine();
		if(findAccount(inputAccount) != null) {
			System.out.print("Enter the amount to be withdrawn: ");
			double withdrawalAmount = Double.parseDouble(input.nextLine()); 
			if(findAccount(inputAccount).withDraw(withdrawalAmount) == true) {
				System.out.println("Withdrawal completed successfully!");
			} else {
				System.out.println("Withdrawal not completed. Available balance is too low");
			}
		} else {
			System.out.println("Account " + inputAccount + " doesn't exist!");
		}

	}

	private static void deleteAccount() {
		System.out.print("\n*** Delete an account ***\n");
		System.out.println("Enter account number: ");
		String deleteAccount = input.nextLine(); 
		if(findAccount(deleteAccount) != null) {
			int i = accountList.indexOf(findAccount(deleteAccount)); 
			accountList.remove(i); 
			System.out.println("Account deleted successfully!");
		} else {
			System.out.println("Nothing deleted. Account: " + deleteAccount + " does not exist!");
		}

	}
}
// End
