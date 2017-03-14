/**
 * Created by shidokht on 2017-02-24.
 */
public class Student extends Person
{
    private int studentNumber;
    public String department;

    public Student(){}
    private void changeId(){}
/*    public String getName (int ID){
        return name;
    }*/

    @Override
    protected void changeAddress(String a) {
        address = a + "zip";
    }
}
