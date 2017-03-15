package qmoodexample;

public class SavingsAccount extends BankAccount {

	private double interestRate;

	public SavingsAccount(double rate) {
		interestRate = rate;
	}

	/**
	 * Adds the earned interest to the account balance.
	 */
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