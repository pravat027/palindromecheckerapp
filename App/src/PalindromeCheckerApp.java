import java.util.*;
interface PalindromeStrategy {
    boolean isPalindrome(String str);
}
class StackStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) stack.push(ch);
        for (char ch : str.toCharArray()) if (ch != stack.pop()) return false;
        return true;
    }
}
class DequeStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : str.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) if (deque.removeFirst() != deque.removeLast()) return false;
        return true;
    }
}
class RecursiveStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();
        return checkRecursive(str, 0, str.length() - 1);
    }
    private boolean checkRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return checkRecursive(str, start + 1, end - 1);
    }
}
class TwoPointerStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();
        int start = 0, end = str.length() - 1;
        while (start < end) if (str.charAt(start++) != str.charAt(end--)) return false;
        return true;
    }
}
public class PalindromeCheckerApp {
    private PalindromeStrategy strategy;
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }
    public boolean check(String str) {
        if (strategy == null) throw new IllegalStateException("Strategy not set");
        return strategy.isPalindrome(str);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PalindromeCheckerApp app = new PalindromeCheckerApp();
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.println("Choose strategy:\n1. Stack\n2. Deque\n3. Recursive\n4. Two-pointer");
        int choice = sc.nextInt();
        switch (choice) {
            case 1 -> app.setStrategy(new StackStrategy());
            case 2 -> app.setStrategy(new DequeStrategy());
            case 3 -> app.setStrategy(new RecursiveStrategy());
            case 4 -> app.setStrategy(new TwoPointerStrategy());
            default -> {
                System.out.println("Invalid choice");
                sc.close();
                return;
            }
        }
        long startTime = System.nanoTime();
        boolean result = app.check(input);
        long endTime = System.nanoTime();
        System.out.println("\nResult: " + (result ? "Palindrome" : "Not a Palindrome"));
        System.out.println("Execution Time: " + (endTime - startTime) + " ns");
        sc.close();
    }
}