package qmoodexample;


public class CheckingAccount extends BankAccount {

	private double interestRate;

	
	public CheckingAccount(double rate) {
		// Initialize transaction count
		interestRate = rate;
	}

	public void addInterest() {
		double interest = getBalance() * interestRate / 100;
		deposit(interest);
	}

	@Override
	public double getRateOfInterest() {
		// TODO Auto-generated method stub
		return interestRate;
	}

	@Override
	public void withdraw(double amount) {

		double currentBal = getBalance() - amount;
		setBalance(currentBal);
	}

}