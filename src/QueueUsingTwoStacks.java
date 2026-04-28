import java.util.Stack;
import java.util.Queue;

public class QueueUsingTwoStacks<T> {

    Stack<T> inputStack = new Stack<>();
    Stack<T> outputStack = new Stack<>();

    public QueueUsingTwoStacks() {

    }


    public void enqueue(T element) {
        inputStack.push(element);
        System.out.println("Enqueued: " + element);
        displayState();
    }


    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Cannot dequeue from an empty queue!");
            return null;
        }
        transferIfNeeded();
        T removed = outputStack.pop();
        System.out.println("Dequeued: " + removed);
        displayState();
        return removed;
    }


    public void peek() {
        if (isEmpty()) {
            System.out.println(" Queue is empty!");
            return;
        }
        transferIfNeeded();
        System.out.println("Front element: " + outputStack.peek());
        displayState();
        return;
    }


    private void transferIfNeeded() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }


    public boolean isEmpty() {

        return inputStack.isEmpty() && outputStack.isEmpty();
    }


    public int size() {
        return inputStack.size() + outputStack.size();
    }


    public void displayState() {
        System.out.println("inputStack: " + inputStack);
        System.out.println("outputStack: " + outputStack);
        System.out.println("Logical Queue: " + getQueueOrder());
        System.out.println("....");
    }


    String getQueueOrder() {

        Stack<T> tempOutput = (Stack<T>) outputStack.clone();

        Stack<T> tempInput = (Stack<T>) inputStack.clone();

        StringBuilder sb = new StringBuilder("[");

        while (!tempOutput.isEmpty()) sb.append(tempOutput.pop()).append(", ");

        for (int i = 0; i < tempInput.size(); i++) sb.append(tempInput.get(i)).append(", ");

        if (sb.length() > 1) sb.setLength(sb.length() - 2);

        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {
        QueueUsingTwoStacks<Integer> queue = new QueueUsingTwoStacks<>();


        queue.enqueue(11);

        queue.enqueue(22);

        queue.enqueue(33);

        queue.peek();

        queue.dequeue();

        queue.enqueue(44);

        queue.enqueue(55);

        queue.peek();

        queue.dequeue();

        queue.dequeue();

        queue.enqueue(60);

        queue.dequeue();

        queue.peek();


        Queue<Integer> javaQueue = new Queue<>


        javaQueue.add(11);

        javaQueue.add(22);

        javaQueue.add(33);

        System.out.println(" Comparison with Java's built-in Queue:");

        System.out.println("Java Queue: "+javaQueue);

        System.out.println("Front element: "+javaQueue.peek());

        javaQueue.remove();

        System.out.println("After dequeue: "+javaQueue);
    }
}
