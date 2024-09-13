package ArraysHashing;

import java.util.Arrays;
import java.util.HashMap;

// Given an array of integers nums and an integer target,
// return the indices i and j such that
// nums[i] + nums[j] == target and i != j.

// You may assume that every input has exactly one pair of
// indices i and j that satisfy the condition.

// Return the answer with the smaller index first.

public class TwoSum {
    public static void main(String args[]) {
       int[] nums = {3,4,5,6};
       int target = 7;
       int[] ans = twoSum(nums, target);
       System.out.println(Arrays.toString(ans));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        int diff = 0;
        HashMap<Integer, Integer> seen = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            diff = target - nums[i];
            if(seen.containsKey(diff)) {
                answer[0] = seen.get(diff);
                answer[1] = i;
                break;
            } else {
                seen.put(nums[i], i);
            }
        }
        // brute force:
        // for(int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[i] + nums[j] == target) {
        //             answer[0] = i;
        //             answer[1] = j;
        //             break;
        //         } 
        //     }
        // }
        return answer;
    }
}
