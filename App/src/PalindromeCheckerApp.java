import java.util.*;
import java.util.Scanner;
public class PalindromeCheckerApp {
    public static boolean checkPalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter         a string: ");
        String input = sc.nextLine();
        if (checkPalindrome(input)) {
            System.out.println("The string is a Palindrome.");
        } else {
            System.out.println("The string is NOT a Palindrome.");
        }
        sc.close();
    }
}