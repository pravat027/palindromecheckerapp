import java.util.*;
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            queue.add(ch);
            stack.push(ch);
        }
        boolean isPalindrome = true;
        while (!queue.isEmpty()) {
            char qChar = queue.remove();
            char sChar = stack.pop();

            if (qChar != sChar) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("The string is  a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }
        sc.close();
    }
}