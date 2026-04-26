import java.util.Stack;
public class DecimalToBinaryConverter {

    public static void main(String[] args) {

    }

    public Integer ToBinaryConverter(String[], int decimal, String quotient, String remainder, String stackcontents, Integer Stack, int nums) {

        Stack<Integer> binary = new Stack<>();

        String result = "";

        binary.push(2);
        binary.push(5);
        binary.push(7);
        binary.push(8);
        binary.push(9);
        binary.push(10);

        if (decimal == 0) {
            return 0;
        } else {
            if (decimal < 0) {
                return 0;
            }
            for (int i = 0; i< binary.length() > i; i++) {

                result += binary.pop();

                System.out.println("quotient :" + quotient);
                System.out.println("remainder :" + remainder);
                System.out.println("stack contents :" + stackcontents);

                while (decimal > 0) {
                    binary.push(decimal % 2);

                    decimal = decimal / 2;

                    while (binary.isEmpty()) {
                        result += binary.pop();

                        System.out.println("all converting binary :" + binary);

                        String myresult = decimal binary();
                        String javaresult = Integer binary();

                        System.out.println("myresult : " + myresult);
                        System.out.println("javaresult : " + javaresult);
                    }
                }

            }
        }
    }
}
