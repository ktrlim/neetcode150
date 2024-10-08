package ArraysHashing;

import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums={2,20,4,10,3,4,5};
        int res = longestConsecutive(nums);
        System.out.println("for " + Arrays.toString(nums) + " the longest is " + res);

    }
    public static int longestConsecutive(int[] nums) {
        int ans = 0;
        Set<Integer> seen = new HashSet<>();
        for (int n : nums) {
            seen.add(n);
        }

        for (int n : seen) {
            int streak = 0;
            int curr = n;
            while(seen.contains(curr)) {
                streak++;
                curr++;
            }
            ans = Math.max(streak, ans);
        }
        return ans;

        /* FIRST ATTEMPT
        Integer max = 0;
        HashMap<Integer, Integer> prev = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if(prev.containsKey(nums[i] - 1)) {
                prev.put(nums[i], prev.get(nums[i-1]) + 1);
                prev.remove(nums[i] - 1);
            } else {
                prev.put(nums[i], 1);
            }
        }
        for (Integer n : prev.keySet()) {
            if (prev.get(n) > max) max = prev.get(n);
        }
        System.out.print(Integer.toString(max));
        return (int)max;
        */
    }
}
