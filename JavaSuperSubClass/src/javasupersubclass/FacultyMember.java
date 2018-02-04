
package javasupersubclass;

/**
 *
 * @author David Kapanga
 */
public class FacultyMember extends Employee{
    private String officeHours;
    private String rank;

    public FacultyMember(String officeHours, String rank, String office, int salary, MyDate dateHired, String name, String address, int phoneNumber, String email) {
        super(office, salary, dateHired, name, address, phoneNumber, email);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "The class is : "+this.getClass().getSimpleName()+"\nThe name is: "+ getName();
    }
    
    
}
