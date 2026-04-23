import java.util.Stack;
import java.util.Iterator;

public class EmployeeStackSearch {
    public static void main(String[]args){

    }
     public EmployeeStackDemo(String Stack) {

        Stack <String> actions  = new Stack<>();
        actions.push("Login");
        actions.push("View Report");
        actions.push("Edit Profile");
        actions.push("Upload File");
        actions.push("Logout");
        actions.push("Login Again");

        System.out.println("Stack (Top to stack");

        int position = actions.search(2);

        if (position != -1) {
            System.out.println("actions 1 found at position (from top): " + position);
        } else {
            System.out.println("actions not found");
        }

        for(int i = actions.size()-1;i>0;i--){

            System.out.println("position " + position + ":" actions.get(i));

            Iterator<String> iterator = actions.iterator();

            int index = 0;

            while (iterator.hasNext()) {

                System.out.println("Index " + index + ": " + iterator.next());

            }
        }
    }


        }




