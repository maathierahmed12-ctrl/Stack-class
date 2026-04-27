import java.util.Stack;

public class TowerOfHanoiSolver {

    static Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();
    Stack<Integer> C = new Stack<>();

    static int moves = 0;

    public static void main(String[] args) {

        int n = 3;
        int initializePegs ;
        System.out.println("initializePegs :");
        displaypags();
        solveHanoi(n, 'A', 'B', 'C');
        System.out.println("total moves :" + moves);
        System.out.println("Minimum required moves :" + (int) (Math.pow(2, n) - 1));

    }

    static void initializePegs(int numDisks) {
        for (int i = numDisks; i >= i--) {
            A.push(i);
        }
    }

    static void solveHanoi(int n, char from, char to, char aux) {
        if (n == 1) {
            return;
        }
        solveHanoi(n - 1, from, aux, to);

        solveHanoi(n - 1, aux, to, from);

    }

    static void moveDisk(char frompeg, char topeg) {
        Stack<Integer> source = new Stack<>();
        Stack<Integer> destination = new Stack<>();
        if (isValidMove(source, destination)) {
            int disk = source.pop();
            destination.push(disk);
            moves++;

            System.out.println("Move " + moves + ": " + frompeg + " → " + topeg + " (Disk " + disk + ")");
            displayPegs();
        } else {
            System.out.println("illegal move!");

        }
    }

     static boolean isValidMove(Stack<Integer> source, Stack<Integer> destination) {
     }

    static void displayPegs(char peg ,int A , int B, int C) {
        System.out.println(" peg A: " + A);
        System.out.println("peg B: " + B);
        System.out.println("peg C: " + C);
    }

    static Stack<Integer> getPeg(char peg  ){
        int A;
        int B;
        int C;


        switch (peg) {
            case 'A':

                return A;

            case 'B':
                return B;

            case 'C':
                return C;

            return null;
        }
    }
}



