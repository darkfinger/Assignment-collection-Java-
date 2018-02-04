/*
 */
package javasupersubclass;

/**
 *
 * @author David Kapanga
 */
public class JavaSuperSubClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Person person=new Person("david", "ad2218", 9999999, "dvdcom"); 
        Status status=new Status("senior");
        Student student=new Student(status,"kapanga", "ad2218", 9999999, "dvdcom");
        MyDate dateHired=new MyDate(01,31,2007);        
        Employee employee=new Employee("b202",80000,dateHired,"Nicol", "ad2218", 9999999, "dvdcom");
        FacultyMember facultyMember=new FacultyMember("12:30","rank","b202",80000,dateHired,"Abbas", "ad2218", 9999999, "dvdcom");
        StaffMember staffMember=new StaffMember("C.E.O","b202",80000,dateHired,"Chef Arnold", "ad2218", 9999999, "dvdcom");
        System.out.println(person.toString());
        System.out.println(student.toString());
        System.out.println(employee.toString());
        System.out.println(facultyMember.toString());
        System.out.println(staffMember.toString());
    }
    
}
