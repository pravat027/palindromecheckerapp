import java.util.Stack;
import java.util.Scanner;
public class PalindromeCheckerApp {
    public static boolean isPalindrome(String input) {
        String cleanInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < cleanInput.length(); i++) {
            stack.push(cleanInput.charAt(i));
        }
        for (int i = 0; i < cleanInput.length(); i++) {
            if (cleanInput.charAt(i) != stack.pop()) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String testWord = "noon";
        if (isPalindrome(testWord)) {
            System.out.println("'" + testWord + "' is a Palindrome!");
        } else {
            System.out.println("'" + testWord + "' is NOT a Palindrome.");
        }
    }
}