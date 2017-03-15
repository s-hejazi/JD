package qmoodexample;

public class Administrator extends Employee {

	Administrator(String s) {

	}

	public String getEmpType() {
		return "administrator";
	}

	public void calcSalary() {
		System.out.println(" salary of adminitrator is 6000");
	}

}
