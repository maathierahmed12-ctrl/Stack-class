import java.util.Stack;
import java.util.Iterator;

public class ParenthesesValidator {
    public static void main(String[] args) {

    }

    public ParenthesesValidator(String Stack , String exp , int i) {



        Stack<String> strings   = new Stack<>();

        strings.push("()");
        strings.push("(())");
        strings.push("({[]})");
        strings.push("(()");
        strings.push("([)]");



        for(int i =0; i<exp.len();  i++);

        char ch = exp.charAt(i);

        if(ch=='(' || ch=='[' || ch=='{' ){
            strings.push("ch");
        }
        if(Stack.isEmpty()){
            return false;

            char top = strings.pop();

            if (!((top == '(' && ch == ')') ||
                    (top == '[' && ch == ']') ||
                    (top == '{' && ch == '}'))) {

                for (String s : strings) {
                    System.out.println(s);
                }
            }
        }
            }
        }


