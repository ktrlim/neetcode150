package Misc;

import java.util.HashMap;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        if (wordPattern(pattern, s)) {
            System.out.println("Pattern '" + pattern + "' and string '" + s + "' follow");
        } else System.out.println("Pattern '" + pattern + "' and string '" + s + "' DO NOT follow");
    }
    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] strs = s.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c) && !map.containsValue(strs[i])) map.put(c, strs[i]);
            else if (!strs[i].equals(map.get(c))) return false;
        }
        return true;
    }
}
