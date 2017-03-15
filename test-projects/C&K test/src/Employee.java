/**
 * Created by param on 2017-02-24.
 */
public class Employee extends Person{
    protected float salary;
    private int EmployeeId=0;
    public Employee(){}
    public int getTaxRate(){
        return 15;
    }
    protected float getSalary(){
        return salary;
    }
    public void personRecord(Person e)
    {
      float tax_rate = ((Employee) e).getTaxRate();
      System.out.println("For Employee ID "+EmployeeId+" Salary with the applied taxes - " + ((salary*tax_rate)/100) );
    }

}
