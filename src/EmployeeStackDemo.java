
import java.util.Stack;

public class EmployeeStackDemo<stack> {
    public static void main (String[] args){
    }

    public EmployeeStackDemo(String Stack) {

         Stack <String> Employee  = new Stack<>();

        Employee.push("Ali");
        Employee.push("Muna");
        Employee.push("Sara");
        Employee.push("Omar");
        Employee.push("Ahmed");

        System.out.println("all Employee :" +  Employee);

        Employee.push("Noor");

        System.out.println("update the  Employee Stack :" + Employee);

    }
}
