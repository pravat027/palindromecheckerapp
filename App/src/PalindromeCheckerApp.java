import java.util.*;
public class PalindromeCheckerApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }
        boolean isPalindrome = true;
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();
            if (front != rear) {
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
            System.out.println("The string is a Palindrome.");
            System.out.println("The string is  a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }
        sc.close();
    }
}