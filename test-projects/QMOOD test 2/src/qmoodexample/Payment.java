package qmoodexample;

abstract public class Payment {

	Payment() {
		System.out.println("created Payment");
	}

	abstract public String getType();

	abstract public void payAdmin();

	abstract public void payTech();

}
