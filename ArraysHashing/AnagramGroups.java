package ArraysHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Given an array of strings strs, group all anagrams
// together into sublists. You may return the output in any order.

// An anagram is a string that contains the exact same
// characters as another string, but the order of the
// characters can be different.


public class AnagramGroups {
    public static void main(String[] args) {
        String[] strs = {"act","pots","tops","cat","stop","hat"};
        List<List<String>> ans = groupAnagrams(strs);
        System.out.println("Original List: " + Arrays.toString(strs));
        System.out.println("Group Anagrams: " + ans);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();
        // for each string s
        for (String s : strs) {
            // count chars in each s
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            // convert count array to string
            String key = Arrays.toString(count);
            // add the count as a key if it DNE already
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            // add the current string s to the HashMap with its key
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
        
    }
    
}
