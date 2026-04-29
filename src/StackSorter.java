import java.util.Stack;

public class StackSorter {

    public static void sortStack(Stack<Integer> stack) {

        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {

            int current = stack.pop();

            while (!tempStack.isEmpty() && tempStack.peek() < current) {

                stack.push(tempStack.pop());
            }

            tempStack.push(current);

            System.out.println("Step: " + tempStack);
        }

        while (!tempStack.isEmpty()) {

            stack.push(tempStack.pop());
        }
    }

    public static void sortStackRecursive(Stack<Integer> stack) {

        if (stack.isEmpty()) return;

        int top = stack.pop();

        sortStackRecursive(stack);

        insertInSortedOrder(stack, top);
    }

    public static void insertInSortedOrder(Stack<Integer> stack, int value) {

        if (stack.isEmpty() || stack.peek() <= value) {

            stack.push(value);

            return;
        }

        int temp = stack.pop();

        insertInSortedOrder(stack, value);

        stack.push(temp);
    }

    public static void displayStack(Stack<Integer> stack, String name) {

        System.out.println(name + ": " + stack);
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(3);

        stack.push(1);

        stack.push(4);

        stack.push(2);

        stack.push(5);

        displayStack(stack, "Before Sorting");

        sortStack(stack);

        displayStack(stack, "After Sorting");

        Stack<Integer> stack2 = new Stack<>();

        stack2.push(10);

        stack2.push(5);

        stack2.push(7);

        stack2.push(1);

        displayStack(stack2, "Before Recursive");

        sortStackRecursive(stack2);

        displayStack(stack2, "After Recursive");
    }
}