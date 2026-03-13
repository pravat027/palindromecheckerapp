 public class PalindromeCheckerApp {
     public static boolean isPalindrome(String str) {
         char[] chars = str.toCharArray();
         int left = 0;
         int right = chars.length - 1;
         while (left < right) {
             if (chars[left] != chars[right]) {
                 return false;
             }
             left++;
             right--;
         }
         return true;
     }

     public static void main(String[] args) {
         String input = "radar";
         System.out.println(isPalindrome(input));
     }
}