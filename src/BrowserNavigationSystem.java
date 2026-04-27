import java.util.*; // لاستعمال Stack و List

public class BrowserNavigationSystem {

    static Stack<String> backStack = new Stack<>();

    static Stack<String> forwardStack = new Stack<>();

    static String currentPage = "Home";

    static List<String> sessionHistory = new ArrayList<>();

    static final int MAX_HISTORY = 10;

    public static void main(String[] args) {

        sessionHistory.add(currentPage);

        showState("Start");

        visitPage("Google");
        visitPage("YouTube");
        visitPage("Facebook");
        visitPage("Twitter");

        goBack();
        goBack();

        goForward();

        visitPage("LinkedIn");

        goBack();
        goForward();
        goForward();
        showSessionHistory();
    }


    public static void visitPage(String url) {

        backStack.push(currentPage);

        if (backStack.size() > MAX_HISTORY) {
            backStack.remove(0);
        }

        currentPage = url;

        forwardStack.clear();

        sessionHistory.add(url);

        showState("Visit: " + url);
    }


    public static void goBack() {

        if (backStack.isEmpty()) {
            System.out.println("");
            return;
        }

        forwardStack.push(currentPage);

        currentPage = backStack.pop();

        showState("Go Back");
    }

    public static void goForward() {

        if (forwardStack.isEmpty()) {
            System.out.println("cannot go back");
            return;
        }

        backStack.push(currentPage);

        currentPage = forwardStack.pop();

        showState("Go Forward");
    }

    public static void showCurrentPage() {

        System.out.println("Current Page: " + currentPage);
    }

    public static void showState(String action) {
        System.out.println(" + action :" + "....");
        showCurrentPage();
        showHistory();
    }

    public static void showHistory() {
        System.out.println("Back Stack: " + backStack);
        System.out.println("Forward Stack: " + forwardStack);
    }

    public static void showSessionHistory() {

        System.out.println(" Session History: " + sessionHistory);
    }
}