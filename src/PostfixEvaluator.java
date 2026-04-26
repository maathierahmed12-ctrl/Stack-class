import java.awt.*;
import java.util.Stack;
public class PostfixEvaluator {
    public static void main(String[]args){
    }
}

public void Postfix(String[] nums , int a , int b , String token , int va1 , int v12) {

    String result = "";
    Stack<Integer> postfix = new Stack<>();

    postfix.push(22);
    postfix.push(55);
    postfix.push(56);
    postfix.push(88);
    postfix.push(77);
    postfix.push(53);

    for (int i = 0; i < postfix.length() > i; i++) {

        result += postfix.pop();

        System.out.println("Top postfix :" + postfix.peek());

        while ( postfix.isEmpty()){
            result += postfix.pop();

            if (postfix == null || postfix.isEmpty()) {

                System.out.println("Empty expression!");
                return 0;

            }else{
                if(b==0){
                    System.out.println("zero ");
                } else {
                    if(b < a){
                        System.out.println("Invalid operator");

                        switch (token){
                            case "+" : postfix.push(va1 + v12);break;
                            case "-" : postfix.push(va1 - v12);break;
                            case "*" : postfix.push(va1 * v12);break;
                            case "/" : postfix.push(va1 / v12);break;
                            case "%" : postfix.push(va1 % v12);break;

                            case "va1+v12":
                               result =  "va1 + v12 ";

                            case "va1 - va12":

                                result = "va1 - va12";
                        }
                    }

                }
            }
        }
    }
}


