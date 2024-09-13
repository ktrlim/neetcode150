package ArraysHashing;

// Given two strings s and t, return true if the
// two strings are anagrams of each other,
// otherwise return false.

// An anagram is a string that contains the exact
// same characters as another string,
// but the order of the characters can be different.

public class IsAnagram {
    public static void main(String[] args) {
        String s = "cat";
        String t = "car";
        boolean ans = isAnagram(s, t);
        System.out.println("The strings " + s + " and " + t + " are anagrams?: " + ans);
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] store = new int[26];

        for (int i = 0; i < s.length(); i++) {
            store[s.charAt(i) - 'a']++;
            store[t.charAt(i) - 'a']--;
        }

        for (int n : store) if (n != 0) return false;

        return true;
    }
}
