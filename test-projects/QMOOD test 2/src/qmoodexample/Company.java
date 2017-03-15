package qmoodexample;

public class Company {

	private Employee emp;

	Company() {
		System.out.println("Company is created");
	}

	public void setEmployee(Employee e, int a) {
		emp = e;
	}

	public void printAll() {
		System.out.println(emp);
	}
}
