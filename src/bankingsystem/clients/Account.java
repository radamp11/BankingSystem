package bankingsystem.clients;

public class Account {
	private String cardNumber;
	private String pinCode;
	private int balance;
	
	
	public Account(String cardNumber, String pinCode) {
		this.setCardNumber(cardNumber);
		this.setPinCode(pinCode);
		this.setBalance(0);
	}


	public String getPinCode() {
		return pinCode;
	}


	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}
}
