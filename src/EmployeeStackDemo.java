
import java.util.Stack;

public class EmployeeStackDemo<stack> {
    public static void main (String[] args){
    }

    public EmployeeStackDemo(String Stack) {

         Stack <String> Employee  = new Stack<>();
        Employee.push("Login");
        Employee.push("View Report");
        Employee.push("Edit Profile");
        Employee.push("Upload File");
        Employee.push("Logout");

        System.out.println("all Employee :" +  Employee);

        Employee.push("Noor");

        System.out.println("update the  Employee Stack :" + Employee);

    }
}
