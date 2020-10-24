package bankingsystem.main;

import java.util.Random;
import java.util.Scanner;

import bankingsystem.clients.Account;
import bankingsystem.clients.Clients;

public class Main {
	public static void initializeMenu() {
		System.out.print("1. Create an account\n2. Log into account\n0. Exit\n>");
	}

	public static void initializeLoggedMenu() {
		System.out.print("1. Balance\n2. Log out\n0. Exit\n>");
	}

	public static Account createAccount() {
		Random random = new Random();
		String card = "400000";
		String pin = "";
		for(int i = 0; i < 10; i++) {
			card += random.nextInt(10);
		}
		for(int i = 0; i < 4; i++) {
			pin += random.nextInt(10);
		}

		Account newAccount = new Account(card, pin);

		System.out.println("Your card has been created\n" +
				"Your card number:\n" + card + "\n" +
				"Your card PIN:\n" + pin + "\n");

		return newAccount;
	}

	public static void main(String[] args) {
		int answer = -1;
		boolean loggedMenu = false;
		Clients clients = new Clients();
		Scanner input = new Scanner(System.in);
		Scanner cardInput = new Scanner(System.in);
		Scanner pinInput = new Scanner(System.in);
		Account currentAccount = null;
		String cardNumber;
		String pinCode;

		while(answer != 0) {
			if(!loggedMenu)
				initializeMenu();
			else
				initializeLoggedMenu();
			answer = input.nextInt();

			if(answer == 1 && !loggedMenu) {
				clients.addAccount(createAccount());
			}
			else if(answer == 2 && !loggedMenu) {
				System.out.println("Enter your card number:\n>");
				cardNumber = cardInput.nextLine();
				System.out.println("Enter your PIN:\n>");
				pinCode = pinInput.nextLine();
				currentAccount = clients.getClient(cardNumber, pinCode);
				if(currentAccount != null) {
					loggedMenu = true;
					System.out.println("You have successfully logged in!\n");
				}

			}
			else if(answer == 1 && loggedMenu) {
				if(currentAccount != null)
					System.out.println("Balance: " + currentAccount.getBalance() + "\n");
				else
					System.out.println("currAccount is null in logged menu - heres a bug");
			}
			else if(answer == 2 && loggedMenu) {
				if(currentAccount != null) {
					System.out.println("You have successfully logged out!\n");
					currentAccount = null;
					loggedMenu = false;
				}
				else
					System.out.println("currAccount is null in logged menu - heres a bug");
			}
			else if(answer != 0){
				System.out.println("You have entered wrong number.\n");
			}

		}
		input.close();
		cardInput.close();
		pinInput.close();
		System.out.println("Bye!");

	}
}
