package qmoodexample;

public class Salary extends Payment {

	private int b;

	Salary(int a) {
		b = a;
	}

	public void payAdmin() {
		System.out.println(b);

	}

	public String getType() {
		return "salary";
	}

	public void payTech() {
		System.out.println(b);

	}
}
