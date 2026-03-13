 class PalindromeCheckerApp {
    static String str = "radar";
    public static void main(String[] args) {
        if (isPalindrome(str)) {
            System.out.println(str + " is a    palindrome.");
        } else {
            System.out.println(str + " is not a   palindrome.");
        }
    }
    static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}