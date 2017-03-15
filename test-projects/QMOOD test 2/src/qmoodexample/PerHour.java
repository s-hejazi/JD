package qmoodexample;

public class PerHour extends Payment {

	private int h;

	PerHour(int a) {

	}

	public void payAdmin() {
		System.out.println(h);
	}

	public String getType() {
		return "per hour";
	}

	public void payTech() {
		System.out.println(h);

	}
}
