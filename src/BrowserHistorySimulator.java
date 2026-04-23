import java.util.Stack;
import java.util.Iterator;
public class BrowserHistorySimulator {

    public static void main(String[]args){

    }
         public BrowserHistorySimulator (String Stack) {

             Stack <String> history   = new Stack<>();


             history .push("google.com");
             history .push("youtube.com");
             history .push("github.com");
             history .push("stackoverflow.com");
             history .push("wikipedia.org");

             System.out.println("all pages in history after each visit : " +Stack);

             int back1 = history.pop();
             System.out.println("Popped element: " + back1);

             int back2 = history.pop();
             System.out.println("Popped element: " + back2);

             System.out.println("current page back :" + Stack);

             System.out.println("Current Page: " + history.peek());

             System.out.println("Is stack empty? " + history.isEmpty());

             System.out.println("after going back :" + Stack);

             history.push("facebook.com");

             history.push("instagram.com");

             System.out.println("final browsing history :"+ Stack);
         }
}
