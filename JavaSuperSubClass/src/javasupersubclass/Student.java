
package javasupersubclass;

/**
 *
 * @author David Kapanga
 */
public class Student extends Person{
    static final Status STATUS=new Status("Senior");

    public Student(Status status, String name, String address, int phoneNumber, String email) {
        super(name, address, phoneNumber, email);
    }

    public Status getSTATUS() {
        return STATUS;
    } 

    @Override
    public String toString() {
        return "The class is : "+this.getClass().getSimpleName()+"\nThe name is: "+ getName();
    }
    
    
    
    
}
