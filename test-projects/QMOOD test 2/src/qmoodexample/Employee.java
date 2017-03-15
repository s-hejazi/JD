package qmoodexample;

abstract public class Employee {
	private String name;
	protected Payment pmnt;

	abstract public void calcSalary();

	abstract public String getEmpType();

	Employee() {
		System.out.println("Employee is created");
	}

	Employee(String s) {
		name = s;
	}

	public String getName() {
		return name;
	}

	public String getPayType() {
		return pmnt.getType();
	}

	public void setPayment(Payment p) {
		pmnt = p;
	}
}
