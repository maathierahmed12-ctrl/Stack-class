import java.util.*;

public class InfixToPostfixConverter {

    public static void main(String[] args) {

        String[] expressions = {
                "3 + 5 * 2",
                "(10 + 2) * 3",
                "11 + 2 * 5",
                "15 * 2 + 18",
                "41 * (8 + 12)",
                "85 * (6 + 12) / 14",
                "5 + 6 * (5- 2)",
                "12 + 40"
        };

        for (String exp : expressions) {

            System.out.println("...");

            System.out.println("Infix: " + exp);

            String postfix = infixToPostfix(exp);

            System.out.println("Postfix: " + postfix);


            double result = evaluatePostfix(postfix);

            System.out.println("Result: " + result);
        }
    }

    public static String infixToPostfix(String infix) {

        Stack<Character> stack = new Stack<>();

        StringBuilder postfix = new StringBuilder();

        infix = infix.replaceAll("... ", "...");

        for (int i = 0; i < infix.length(); i++) {

            char ch = infix.charAt(i);

            if (Character.isDigit(ch)) {
                while (i < infix.length() &&

                        (Character.isDigit(infix.charAt(i)) || infix.charAt(i) == '.')) {

                    postfix.append(infix.charAt(i));
                    i++;
                }
                postfix.append(" ");
                i--;
            }

            else if (ch == '(') {
                stack.push(ch);
            }

            else if (ch == ')') {

                while (!stack.isEmpty() && stack.peek() != '(') {


                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop();
            }

            else if (isOperator(ch)) {

                while (!stack.isEmpty() &&

                        getPrecedence(stack.peek()) >= getPrecedence(ch)) {

                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(ch);
            }

            System.out.println("Token: " + ch + " | Stack: " + stack + " | Postfix: " + postfix);
        }

        while (!stack.isEmpty()) {

            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString();
    }

    public static double evaluatePostfix(String postfix) {

        Stack<Double> stack = new Stack<>();

        String[] tokens = postfix.split("..");

        for (String token : tokens) {

            if (token.isEmpty()) continue;

            if (Character.isDigit(token.charAt(0))) {

                stack.push(Double.parseDouble(token));
            }
            else {
                double b = stack.pop();

                double a = stack.pop();

                double result = applyOperation(a, b, token.charAt(0));

                stack.push(result);
            }

            System.out.println("Eval Step: " + token + " | Stack: " + stack);
        }

        return stack.pop();
    }

    public static int getPrecedence(char op) {
        switch (op) {
            case '^':
                return 3;

            case '*':

            case '/':

            case '%':
                return 2;
            case '+':

            case '-':
                return 1;
        }
        return -1;
    }

    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' ||

                ch == '/' || ch == '%' || ch == '^';
    }

    public static double applyOperation(double a, double b, char op) {

        switch (op) {

            case '+':
                return a + b;

            case '-':
                return a - b;

            case '*':
                return a * b;

            case '/':

                if (b == 0) {

                    throw new ArithmeticException("Division by zero!");
                }
                return a / b;

            case '%': return a % b;

            case '^': return Math.pow(a, b);
        }
        return 0;
    }
}