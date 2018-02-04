
package javasupersubclass;

/**
 *
 * @author David Kapanga
 */
public class StaffMember extends Employee{
    private String title;

    public StaffMember(String title, String office, int salary, MyDate dateHired, String name, String address, int phoneNumber, String email) {
        super(office, salary, dateHired, name, address, phoneNumber, email);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "The class is : "+this.getClass().getSimpleName()+"\nThe name is: "+ getName();
    }
    
    
}
