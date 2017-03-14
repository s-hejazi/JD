/**
 * Created by shidokht on 2017-02-24.
 */
public class Employee extends Person{
    protected float salary;
    private int EmployeeId;
    public Employee(){}
    public int getTaxRate(){
        return 15;
    }
    protected float getSalary(){
        return salary;
    }

}
