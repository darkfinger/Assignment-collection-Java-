
package javasupersubclass;

/**
 *
 * @author David Kapanga
 */
public class Employee extends Person{
    private String office;
    private int salary;
    private MyDate dateHired;

    public Employee(String office, int salary, MyDate dateHired, String name, String address, int phoneNumber, String email) {
        super(name, address, phoneNumber, email);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
    }

    @Override
    public String toString() {
        return "The class is : "+this.getClass().getSimpleName()+"\nThe name is: "+ getName();
    }
    
    
}
