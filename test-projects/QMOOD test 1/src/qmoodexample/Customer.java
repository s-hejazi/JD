package qmoodexample;

public class Customer {
	private String firstName;
	private String lastName;
	private String number;
	private BankAccount acc;

	Customer(String firstName, String lastName, String number) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;

	}

	public void setAccount(BankAccount account) {
		acc = account;
	}

	public void printAll() {
		System.out.println("firstname =" + firstName);
		System.out.println("lastname  =" + lastName);

		System.out.println("number =" + number);

		System.out.println("account type =" + acc);

	}

}