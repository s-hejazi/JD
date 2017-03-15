package qmoodexample;

public abstract class BankAccount {
	private double balance;
	private double interest;

	abstract void withdraw(double amount);

	abstract double getRateOfInterest();

	abstract void addInterest();

	/**
	 * Constructs a bank account with a zero balance.
	 */
	public BankAccount() {
		balance = 0;
	}

	public BankAccount(double interestRate) {
		interest = interestRate;
	}

	/**
	 * Deposits money into the bank account.
	 * 
	 * @param amount
	 *            the amount to deposit
	 */
	public void deposit(double amount) {
		balance = balance + amount;
	}

	/**
	 * Gets the current balance of the bank account.
	 * 
	 * @return the current balance
	 */
	public double getBalance() {
		return balance;
	}

	public void setBalance(double bal) {
		balance = bal;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest_rate) {
		interest = interest_rate;
	}

}