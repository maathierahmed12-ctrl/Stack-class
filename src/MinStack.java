import java.util.Stack;

public class MinStack {

    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();


    public void push(int value) {
        mainStack.push(value);


        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }

        System.out.println("Push: " + value);
        display();
    }


    public Integer pop() {
        if (mainStack.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }

        int removed = mainStack.pop();

        if (removed == minStack.peek()) {
            minStack.pop();
        }

        System.out.println("Pop: " + removed);
        display();
        return removed;
    }


    public Integer peek() {
        if (mainStack.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return mainStack.peek();
    }


    public Integer getMin() {
        if (minStack.isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return minStack.peek();
    }


    public boolean isEmpty() {
        return mainStack.isEmpty();
    }


    public void display() {
        System.out.println("Main Stack: " + mainStack);
        System.out.println("Min Stack : " + minStack);
        System.out.println("Current Min: " + getMin());
        System.out.println("....");
    }

    public static void main(String[] args) {

        MinStack M = new MinStack();

        M.push(9);
        M.push(2);
        M.push(7);
        M.getMin();

        M.push(4);
        M.push(5);
        M.getMin();

        M.pop();
        M.pop();
        M.getMin();

        M.push(10);
        M.getMin();

        M.pop();
        M.pop();
        M.pop();
        M.pop();
    }
}
