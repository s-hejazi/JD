/**
 * Created by shidokht on 2017-02-20.
 */
public class Person {

    public String name;
    private int Id;
    protected String address;

    public Person(){}
    public void changeName( String n){
        name = n;
    }
    protected void changeAddress(String a){
        address = a;
    }
}
