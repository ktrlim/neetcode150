package TwoPointers;

import java.util.*;

public class ValidPalindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Type a word to see if it's a palindrome: ");
        String s = in.nextLine();
        if (isPalindrome(s)) {
            System.out.println(s + " is a palindrome!");
        } else System.out.println(s + " is NOT a palindrome");
    }
    public static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (l < r && ! Character.isLetterOrDigit(s.charAt(r))) r--;
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
            l++;
            r--;
        }
        return true;
    }
}
