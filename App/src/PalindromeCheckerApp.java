import java.util.*;
interface PalindromeStrategy {
    boolean isPalindrome(String str);
}
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }
        for (char ch : str.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : str.toCharArray()) {
            deque.addLast(ch);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}
public class PalindromeCheckerApp {
    private PalindromeStrategy strategy;
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }
    public boolean check(String str) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set");
        }
        return strategy.isPalindrome(str);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PalindromeCheckerApp app = new PalindromeCheckerApp();
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.println("Choose strategy: 1.Stack  2.Deque");
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> app.setStrategy(new StackStrategy());
            case 2 -> app.setStrategy(new DequeStrategy());
            default -> {
                System.out.println("Invalid choice");
                sc.close();
                return;
            }
        }
        if (app.check(input)) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }
        sc.close();
    }
}