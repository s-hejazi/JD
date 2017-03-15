/**
 * Created by paramtrivedi on 3/14/17.
 */
public class EmployeePayroll {
    Employee emp;
    int payroll_date,salary,payroll_amount=0;
    String expense_information;
    EmployeePayroll() {}
    void generatePayroll() {
        System.out.println("The Employee information " + emp.name);
        // Creating Payroll
        payroll_amount+=salary;
        System.out.println("Salary information " + payroll_amount + "On date " + payroll_date);

    }
}
