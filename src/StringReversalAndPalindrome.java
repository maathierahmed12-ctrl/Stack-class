import java.util.Stack;

public class ReversalAndPalindrome {
    public static void main(String[] args) {
    }

    public String ReversaString(String input, String revers , String Original , String palindrome) {

        if (input == null) return null;

        Stack<String> characters = new Stack<>();

        characters.push("racecar");
        characters.push("level");
        characters.push("hello");
        characters.push("madam");
        characters.push("java");
        characters.push("php");

        for (int i = 0; input.length(); i++) {

            characters.push("input.charAt(i)");

            String result = "";

            while (!characters.isEmpty()) {

                result += characters.pop();

                return result;
                String reversed = revers;

                System.out.println("Original: " + Original);
                System.out.println("Reversed: " + reversed);
                System.out.println("Palindrome: " + palindrome);

            }
        }
    }

}




