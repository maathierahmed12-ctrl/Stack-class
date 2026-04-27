import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementFinder {

    public static int[] NextGreaterElement(int[] arr) {
        int n = arr.length;

        int[] result = new int[n];

        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {


            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {

                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        return result;
    }


    public static int[] NextGreaterElementCircular(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        // Traverse twice to simulate circular behavior
        for (int i = 0; i < 2 * n; i++) {
            int num = arr[i % n];
            while (!stack.isEmpty() && arr[stack.peek()] < num) {
                result[stack.pop()] = num;
            }
            if (i < n) stack.push(i);
        }
        return result;
    }

    public static int[] NextSmallerElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        return result;
    }

    public static void displayResults(int[] arr, int[] result) {
        System.out.println("Index | Element | Next");
        System.out.println("...");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%5d | %7d | %4d\n", i, arr[i], result[i]);
        }
        System.out.println();
    }

    public static int[] NextGreater(int[] arr) {
        int n = arr.length;

        int[] result = new int[n];

        Arrays.fill(result, -1);

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (arr[j] > arr[i]) {

                    result[i] = arr[j];

                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] testArrays = {

                {5, 5, 9, 22},

                {14, 7, 5, 12},

                {1, 4, 3, 7, 5},

                {5, 5, 3, 8, 1},

                {7},

                {}
        };

        for (int[] arr : testArrays) {

            System.out.println("Array: " + Arrays.toString(arr));


            int[] nge = NextGreaterElement(arr);

            System.out.println("Next Greater Element (Stack O(n)):");

            displayResults(arr, nge);

            int[] brute = NextGreater(arr);

            System.out.println("Next Greater Element (Brute Force O(n^2)):");

            displayResults(arr, brute);


            int[] circular = NextGreaterElementCircular(arr);

            System.out.println("Next Greater Element (Circular):");

            displayResults(arr, circular);

            int[] nse = NextSmallerElement(arr);

            System.out.println("Next Smaller Element:");

            displayResults(arr, nse);


            System.out.println("....");
        }
    }
}
