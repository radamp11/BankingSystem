package bankingsystem.clients;

import java.util.ArrayList;

public class Clients {
	private ArrayList<Account> clients = new ArrayList<Account>();

	public void addAccount(Account account) {
		this.clients.add(account);
	}
	
	public ArrayList<Account> getClients() {
		return clients;
	}

	public Account getClient(String cardNumber, String pinCode) {
		for(Account account : clients) {
			if(cardNumber.equals(account.getCardNumber()) && pinCode.equals(account.getPinCode()))
				return account;
		}
		System.out.println("Wrong card number or PIN!\n");
		return null;
	}
	
}
